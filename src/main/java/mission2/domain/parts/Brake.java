package mission2.domain.parts;

public enum Brake {
    MANDO {
        @Override
        public String toString() {
            return "Mando";
        }
    }, CONTINENTAL {
        @Override
        public String toString() {
            return "Continental";
        }
    }, BOSCH_B {
        @Override
        public String toString() {
            return "Bosch";
        }
    }, NONE {
        @Override
        public String toString() {
            return "None";
        }
    };
}
