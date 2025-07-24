package mission2;

public enum CarType {
    SEDAN {
        @Override
        public String toString() {
            return "Sedan";
        }

    }, SUV {
        @Override
        public String toString() {
            return "SUV";
        }
    }, TRUCK {
        @Override
        public String toString() {
            return "Trunk";
        }
    }, NONE {
        @Override
        public String toString() {
            return "None";
        }
    };
}
