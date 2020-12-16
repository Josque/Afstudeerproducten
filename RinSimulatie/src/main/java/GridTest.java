/*
Copyright (c) 2020 Joost Wagensveld

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/


import com.github.rinde.rinsim.core.Simulator;
import com.github.rinde.rinsim.core.model.road.RoadModelBuilders;
import com.github.rinde.rinsim.geom.*;
import com.github.rinde.rinsim.ui.View;
import com.github.rinde.rinsim.ui.renderers.AGVRenderer;
import com.github.rinde.rinsim.ui.renderers.WarehouseRenderer;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import javax.measure.unit.SI;

import static com.google.common.collect.Lists.newArrayList;

/**
 * This is the gridtest file to create a grid to use for the simulation used in my graduation project
 *
 * @author Joost Wagensveld
 */
public final class GridTest {
    
    private static final double VEHICLE_LENGTH = 1.5;
    private static final int NUM_PLATFORMS = 15;
    
    private GridTest() {}
    
    /**
     * @param args - No args.
     */
    public static void main(String[] args) {
        run();
    }
    
    /**
     * Runs the example.
     */
    public static void run() {
        View.Builder viewBuilder = View.builder()
                .with(WarehouseRenderer.builder()
                        .withMargin(VEHICLE_LENGTH))
                .with(AGVRenderer.builder()
                        .withDifferentColorsForVehicles());
        viewBuilder =
                viewBuilder.withTitleAppendix("Agile Transportgrid Example");
        
        final Simulator sim = Simulator.builder()
                .addModel(
                        RoadModelBuilders.dynamicGraph(GraphCreator.createTestGraph())
                                .withCollisionAvoidance()
                                .withDistanceUnit(SI.METER)
                                .withVehicleLength(VEHICLE_LENGTH)
                )
                .addModel(viewBuilder)
                .build();
        
        for (int i = 0; i < NUM_PLATFORMS; i++) {
            sim.register(new TransportAgent(sim.getRandomGenerator()));
        }
        
        sim.start();
    }
    
    static class GraphCreator {
        GraphCreator() {}
        
        static ImmutableTable<Integer, Integer, Point> createMatrix(
                int cols, int rows, Point offset) {
            final ImmutableTable.Builder<Integer, Integer, Point> builder =
                    ImmutableTable.builder();
            for (int c = 0; c < cols; c++) {
                for (int r = 0; r < rows; r++) {
                    builder.put(r, c, new Point(
                            offset.x + c * VEHICLE_LENGTH * 4,
                            offset.y + r * VEHICLE_LENGTH * 4));
                }
            }
            return builder.build();
        }
    
        static ListenableGraph<LengthData> createTestGraph() {
            final Graph<LengthData> g = new TableGraph<>();
            final Table<Integer, Integer, Point> matrix = createMatrix(
                    10, 10, new Point(0, 0));
            for (int i = 1; i < (matrix.columnMap().size()) - 1; i++) {
                final Iterable<Point> path;
                if (i % 2 == 0) {
                    path = matrix.column(i).values();
                    Graphs.addBiPath(g, path);
                }
            }
            
            for (int i = 0; i < matrix.rowMap().size(); i++) {
                
                final Iterable<Point> path;
                if (i % 2 == 0) {
                    path = Lists.reverse(newArrayList(matrix.row(i).values()));
                } else {path = matrix.row(i).values();}
                Graphs.addPath(g, path);
            }
            Graphs.addPath(g, matrix.column(0).values());
            Graphs.addPath(g, Lists.reverse(newArrayList(matrix.column(
                    matrix.columnKeySet().size() - 1).values())));
            return new ListenableGraph<>(g);
        }
        
    }
}
