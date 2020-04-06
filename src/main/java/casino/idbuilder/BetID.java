package casino.idbuilder;

import java.util.Objects;
import java.util.UUID;

public class BetID extends GeneralID {
        private UUID id;
        public BetID(UUID id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            casino.idbuilder.BetID betID = (casino.idbuilder.BetID) o;
            return Objects.equals(id, betID.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
}
