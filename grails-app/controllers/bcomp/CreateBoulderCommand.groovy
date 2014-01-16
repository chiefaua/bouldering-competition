package bcomp

import bcomp.gym.Boulder
import bcomp.gym.BoulderColor
import bcomp.gym.FloorPlan
import bcomp.gym.Grade
import bcomp.gym.Gym
import bcomp.gym.Location
import bcomp.gym.OnFloorPlan
import grails.validation.Validateable

@Validateable
class CreateBoulderCommand {

    Gym gym

    FloorPlan floorPlan
    Double x, y

    Boulder.GradeCertainty gradeCertainty
    String grade

    String gradeRangeLow
    String gradeRangeHigh

    BoulderColor color


    static constraints = {
        importFrom Boulder

        floorPlan nullable: false, validator: { floorPlan, cmd ->
            return cmd.gym.floorPlans.contains(floorPlan)
        }
        x min: 0.0d, max: 1.0d
        y min: 0.0d, max: 1.0d
    }

}
