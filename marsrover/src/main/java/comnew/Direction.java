package comnew;

public enum Direction implements Turn{
    East {
        @Override
        public Direction turnLeft() {
            return Direction.South;
        }

        @Override
        public Direction turnRight() {
            return Direction.North;
        }
    },
    North {
        @Override
        public Direction turnLeft() {
            return Direction.East;
        }

        @Override
        public Direction turnRight() {
            return Direction.West;
        }
    },
    South {
        @Override
        public Direction turnLeft() {
            return Direction.West;
        }

        @Override
        public Direction turnRight() {
            return Direction.East;
        }
    },
    West {
        @Override
        public Direction turnLeft() {
            return Direction.North;
        }

        @Override
        public Direction turnRight() {
            return Direction.South;
        }
    };
}
