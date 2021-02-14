package strategy;

import java.util.Set;
import java.util.TreeSet;

public class ClosestFirstStrategy implements ParkingStrategy {

    private Set<Integer> slots;

    public ClosestFirstStrategy() {
        this.slots = new TreeSet<>();
    }

    public Set<Integer> getSlots() {
        return slots;
    }

    @Override
    public void addSlot(Integer slotNumber) {
        slots.add(slotNumber);
    }

    @Override
    public void removeSlot(Integer slotNumber) {
        slots.remove(slotNumber);
    }

    @Override
    public Integer getNextFreeSlot() {
        if (slots.isEmpty()) {
            throw new RuntimeException("NO free slots left");
        }
        return slots.stream().findFirst().get();
    }
}
