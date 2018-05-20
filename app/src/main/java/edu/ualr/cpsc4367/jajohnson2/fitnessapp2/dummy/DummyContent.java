package edu.ualr.cpsc4367.jajohnson2.fitnessapp2.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 7;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static String intToChar(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    private static DummyItem createDummyItem(int position) {
        if (position == 1) {
            return new DummyItem(String.valueOf(position), "Calendar", makeDetails(position));
        }
        return new DummyItem(String.valueOf(position), "Day " + intToChar(position-1), makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();

        if (position == 1) {
            builder.append( "Phase 1 (1-3 weeks):\n   Mon: Day A\n   Wed: Day B\n   Fri: Day A\n\n" +
                            "Phase 2 (weeks to months):\n   Mon: Day C\n   Wed: Day D\n   Fri: Day C\n\n" +
                            "Phase 3 (trainee decides):\n   Mon: Day E\n   Wed: Day F\n   Fri: Day E");
        }

        else {
            builder.append("\n"+"Moves to Complete Workout ").append(position-1 + ":\n");
            switch (position) {
                case 2: builder.append("\n"+"Squat (3 sets x 5 reps)"+"\n\n"+"Bench Press (3 sets x 5 reps)"+"\n\n"+"Deadlift (1 set x 5 reps)"+"\n"); break;
                case 3: builder.append("\n"+"Squat (3 sets x 5 reps)"+"\n\n"+"Bench Press (3 sets x 5 reps)"+"\n\n"+"Deadlift (1 set x 5 reps)"+"\n"); break;
                case 4: builder.append("\n"+"Squat (3 sets x 5 reps)"+"\n\n"+"Bench Press (3 sets x 5 reps)"+"\n\n"+"Deadlift (1 set x 5 reps)"+"\n"); break;
                case 5: builder.append("\n"+"Squat (3 sets x 5 reps)"+"\n\n"+"Bench Press (3 sets x 5 reps)"+"\n\n"+"Power Clean (5 sets x 3 reps)"+"\n"); break;
                case 6: builder.append("\n"+"Squat (3 sets x 5 reps)"+"\n\n"+"Bench Press (3 sets x 5 reps)"+"\n\n"+"Deadlift (1 set x 5 reps) OR "+"\n"+"Power Clean (5 sets x 3 reps)"+"\n"); break;
                case 7: builder.append("\n"+"Squat (3 sets x 5 reps)"+"\n\n"+"Bench Press (3 sets x 5 reps)"+"\n\n"+"Chin ups"+"\n"); break;
                default: break;
            }
        }

        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
