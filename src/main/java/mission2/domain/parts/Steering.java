package mission2.domain.parts;

public enum Steering {
    BOSCH {
        @Override
        public String toString() {
            return "Bosch";
        }
    }, MOBIS {
        @Override
        public String toString() {
            return "Mobis";
        }
    }, NONE {
        @Override
        public String toString() {
            return "None";
        }
    };
}
