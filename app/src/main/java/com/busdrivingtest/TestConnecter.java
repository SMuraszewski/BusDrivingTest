package com.busdrivingtest;

import android.provider.BaseColumns;

public final class TestConnecter {

    private TestConnecter() {
    }

    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME = "pytania";
        public static final String COLUMN_QUESTION = "pytanie";
        public static final String COLUMN_ANSWER1 = "odpA";
        public static final String COLUMN_ANSWER2 = "odpB";
        public static final String COLUMN_ANSWER3 = "odpC";
        public static final String COLUMN_ANSWER_NR = "nrPoprawnej";
    }
}

