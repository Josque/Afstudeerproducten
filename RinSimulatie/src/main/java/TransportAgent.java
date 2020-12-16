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

import com.github.rinde.rinsim.core.model.road.CollisionGraphRoadModelImpl;
import com.github.rinde.rinsim.core.model.road.MovingRoadUser;
import com.github.rinde.rinsim.core.model.road.RoadModel;
import com.github.rinde.rinsim.core.model.time.TickListener;
import com.github.rinde.rinsim.core.model.time.TimeLapse;
import com.github.rinde.rinsim.geom.Point;
import com.google.common.base.Optional;
import org.apache.commons.math3.random.RandomGenerator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is file sets the definition that the roadusers have when in the grid
 *
 * @author Joost Wagensveld
 */

class TransportAgent implements TickListener, MovingRoadUser {
    private final RandomGenerator rand;
    private Optional<CollisionGraphRoadModelImpl> grid;
    private Optional<Point> destination;
    private Queue<Point> path;

    TransportAgent(RandomGenerator r) {
        rand = r;
        grid = Optional.absent();
        destination = Optional.absent();
        path = new LinkedList<>();
    }

    @Override
    public void initRoadUser(RoadModel model) {
        grid = Optional.of((CollisionGraphRoadModelImpl) model);
        Point p;
        do {
            p = model.getRandomPosition(rand);
        } while (grid.get().isOccupied(p));
        grid.get().addObjectAt(this, p);

    }

    @Override
    public double getSpeed() {
        return 1;
    }

    void nextDestination() {
        destination = Optional.of(grid.get().getRandomPosition(rand));
        path = new LinkedList<>(grid.get().getShortestPathTo(this,
                destination.get()));
    }

    @Override
    public void tick(TimeLapse timeLapse) {
        if (!destination.isPresent()) {
            nextDestination();
        }
        try {
            grid.get().followPath(this, path, timeLapse);
        }
        catch (Exception e){
            nextDestination();
        }
        if (grid.get().getPosition(this).equals(destination.get())) {
            nextDestination();
        }
    }

    @Override
    public void afterTick(TimeLapse timeLapse) {}

}
