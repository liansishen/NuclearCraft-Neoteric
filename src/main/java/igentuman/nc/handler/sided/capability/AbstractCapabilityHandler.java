package igentuman.nc.handler.sided.capability;

import igentuman.nc.handler.sided.SidedContentHandler;
import igentuman.nc.handler.sided.SlotModePair;

import java.util.HashMap;

public abstract class AbstractCapabilityHandler {
    public int inputSlots;
    public int outputSlots;

    public boolean sideMapUpdated = true;
    public HashMap<Integer, SlotModePair[]> sideMap;

    protected void initDefault() {
        sideMap = new HashMap<>();
        for (SidedContentHandler.RelativeDirection side : SidedContentHandler.RelativeDirection.values()) {
            SlotModePair[] defaultSide = new SlotModePair[inputSlots+outputSlots];
            for (int i = 0; i < inputSlots; i++) {
                defaultSide[i] = new SlotModePair(SlotModePair.SlotMode.INPUT, i);
            }
            for (int i = inputSlots; i < inputSlots+outputSlots; i++) {
                defaultSide[i] = new SlotModePair(SlotModePair.SlotMode.OUTPUT, i);
            }
            sideMap.put(side.ordinal(), defaultSide);
        }
    }

    public SidedContentHandler.SlotType getType(int slot) {
        return slot < inputSlots ? SidedContentHandler.SlotType.INPUT : SidedContentHandler.SlotType.OUTPUT;
    }

    public SlotModePair.SlotMode getMode(int slot, int side) {
        return sideMap.get(side)[slot].getMode();
    }

    public int toggleMode(int slot, int side) {
        SlotModePair[] sideSlots = sideMap.get(side);
        SlotModePair slotModePair = sideSlots[slot];
        SlotModePair.SlotMode mode = slotModePair.getMode();
        sideMapUpdated = true;
        if(getType(slot) == SidedContentHandler.SlotType.INPUT) {
            switch (mode) {
                case DISABLED -> sideSlots[slot] = new SlotModePair(SlotModePair.SlotMode.INPUT, slot);
                case INPUT -> sideSlots[slot] = new SlotModePair(SlotModePair.SlotMode.PULL, slot);
                case PULL -> sideSlots[slot] = new SlotModePair(SlotModePair.SlotMode.DISABLED, slot);
            }
        } else {
            switch (mode) {
                case DISABLED -> sideSlots[slot] = new SlotModePair(SlotModePair.SlotMode.OUTPUT, slot);
                case OUTPUT -> sideSlots[slot] = new SlotModePair(SlotModePair.SlotMode.PUSH, slot);
                case PUSH -> sideSlots[slot] = new SlotModePair(SlotModePair.SlotMode.PUSH_EXCESS, slot);
                case PUSH_EXCESS -> sideSlots[slot] = new SlotModePair(SlotModePair.SlotMode.DISABLED, slot);
            }
        }
        return sideSlots[slot].getMode().ordinal();
    }
}
