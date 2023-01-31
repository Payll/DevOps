package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    public void testNextDateEndOfYear() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(31, 12, NotLeapYear);
        assertEquals(new Date(1, 1, NotLeapYear + 1), date.nextDate());
    }

    @Test
    public void testNextDateEndOfMonth() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(31, 1, NotLeapYear);
        assertEquals(new Date(1, 2, NotLeapYear), date.nextDate());
    }

    @Test
    public void testNextDateEndOfThirtyDaysMonthWith30Day() {
        boolean isValid = true;
        int NotLeapYear = 2017; // 2017 % 4 != 0
        int[] monthsWith30Days = {4, 6, 9, 11}; // months with 30 days
        for (int month : monthsWith30Days) {
            Date date = new Date(30, month, NotLeapYear);
            Date d = new Date(1, month + 1, NotLeapYear);
            if (!date.nextDate().equals(d)) {
                isValid = false;
                break;
            }
        }
        assertTrue(isValid);
    }

    @Test
    public void testNextDateEndOfThirtyOneDaysMonth() {
        boolean isValid = true;
        int[] monthsWith31Days = {1, 3, 5, 7, 8, 10}; // months with 31 days
        int NotLeapYear = 2017; // 2017 % 4 != 0
        for (int month : monthsWith31Days) {
            Date date = new Date(31, month, NotLeapYear);
            Date d = new Date(1, month + 1, NotLeapYear);
            if (!date.nextDate().equals(d)) {
                isValid = false;
                break;
            }
        }
        assertTrue(isValid);
    }

    @Test
    public void testNextDateWithMonth2Day28NotLeapYear() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(28, 2, NotLeapYear);
        assertEquals(new Date(1, 3, NotLeapYear), date.nextDate());
    }

    @Test
    public void testNextDateWithMonth2Day29LeapYear() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        Date date = new Date(29, 2, LeapYear);
        assertEquals(new Date(1, 3, LeapYear), date.nextDate());
    }

    @Test
    public void testNextDate() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        Date date = new Date(15, 11, LeapYear);
        assertEquals(new Date(16, 11, LeapYear), date.nextDate());
    }

    @Test
    public void testNextDateWithInvalideDate() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(42, 11, NotLeapYear);
        assertNull(date.nextDate());
    }


    @Test
    public void testPreviousDateBeginOfYear() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(1, 1, NotLeapYear);
        assertEquals(new Date(31, 12, NotLeapYear - 1), date.previousDate());
    }

    @Test
    public void testPreviousDateBeginOfMonth() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(1, 2, NotLeapYear);
        assertEquals(new Date(31, 1, NotLeapYear), date.previousDate());
    }

    @Test
    public void testPreviousDateBeginOfThirtyDaysMonthWith30Day() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        boolean isValid = true;
        int[] monthsAfterMonthWith30Days = {5, 7, 10, 12}; // months after month with 30 days
        for (int month : monthsAfterMonthWith30Days) {
            Date date = new Date(1, month, NotLeapYear);
            Date d = new Date(30, month - 1, NotLeapYear);
            if (!date.previousDate().equals(d)) {
                isValid = false;
                break;
            }
        }
        assertTrue(isValid);
    }

    @Test
    public void testPreviousDateBeginOfThirtyOneDaysMonth() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        boolean isValid = true;
        int[] monthsAfterMonthWith31Days = {2, 4, 6, 8, 9, 11}; // months after month with 31 days
        for (int month : monthsAfterMonthWith31Days) {
            Date date = new Date(1, month, NotLeapYear);
            Date d = new Date(31, month - 1, NotLeapYear);
            if (!date.previousDate().equals(d)) {
                isValid = false;
                break;
            }
        }
        assertTrue(isValid);
    }

    @Test
    public void testPreviousDateWithMonth3Day1NotLeapYear() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(1, 3, NotLeapYear);
        assertEquals(new Date(28, 2, NotLeapYear), date.previousDate());
    }

    @Test
    public void testPreviousDateWithMonth3Day1LeapYear() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        Date date = new Date(1, 3, LeapYear);
        assertEquals(new Date(29, 2, LeapYear), date.previousDate());
    }

    @Test
    public void testPreviousDate() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        Date date = new Date(15, 11, LeapYear);
        assertEquals(new Date(14, 11, LeapYear), date.previousDate());
    }

    @Test
    public void testPreviousDateWithInvalideDate() {
        int NotLeapYear = 2017; // 2017 % 4 != 0
        Date date = new Date(42, 11, NotLeapYear);
        assertNull(date.previousDate());
    }

    @Test
    public void testCompareToWithSameDate() {
        Date date1 = new Date(1, 1, 2017);
        Date date2 = new Date(1, 1, 2017);
        assertEquals(0, date1.compareTo(date2));
    }

    @Test
    public void testCompareToWithNotSameYearsLower() {
        Date date1 = new Date(1, 1, 2017);
        Date date2 = new Date(1, 1, 2018);
        assertEquals(-1, date1.compareTo(date2));
    }

    @Test
    public void testCompareToWithNotSameYearsUpper() {
        Date date1 = new Date(1, 1, 2018);
        Date date2 = new Date(1, 1, 2017);
        assertEquals(1, date1.compareTo(date2));
    }

    @Test
    public void testCompareToWithNotSameMonthsLower() {
        Date date1 = new Date(1, 1, 2017);
        Date date2 = new Date(1, 2, 2017);
        assertEquals(-1, date1.compareTo(date2));
    }

    @Test
    public void testCompareToWithNotSameMonthsUpper() {
        Date date1 = new Date(1, 2, 2017);
        Date date2 = new Date(1, 1, 2017);
        assertEquals(1, date1.compareTo(date2));
    }

    @Test
    public void testCompareToWithNotSameDaysLower() {
        Date date1 = new Date(1, 1, 2017);
        Date date2 = new Date(2, 1, 2017);
        assertEquals(-1, date1.compareTo(date2));
    }

    @Test
    public void testCompareToWithNotSameDaysUpper() {
        Date date1 = new Date(2, 1, 2017);
        Date date2 = new Date(1, 1, 2017);
        assertEquals(1, date1.compareTo(date2));
    }


    @Test
    public void testIsLeapYear() {
        int LeapYear = 2016; // 2016 % 4 = 0 and 2016 % 100 != 0 or 2016 % 400 = 0
        int NotLeapYear = 2017; // 2017 % 4 != 0
        assertFalse(Date.isLeapYear(NotLeapYear));
        assertTrue(Date.isLeapYear(LeapYear));
    }

    @Test
    public void testToString() {
        Date date = new Date(1, 1, 2016);
        assertEquals("01/01/2016", date.toString());
    }

    @Test
    public void testEqualsWithSameDate() {
        Date date1 = new Date(1, 1, 2016);
        Date date2 = new Date(1, 1, 2016);
        assertTrue(date1.equals(date2));
    }

    @Test
    public void testEqualsWithNotSameYear() {
        Date date1 = new Date(1, 1, 2016);
        Date date2 = new Date(1, 1, 2017);
        assertFalse(date1.equals(date2));
    }

    @Test
    public void testEqualsWithNotSameMonth() {
        Date date1 = new Date(1, 1, 2016);
        Date date2 = new Date(1, 2, 2016);
        assertFalse(date1.equals(date2));
    }

    @Test
    public void testEqualsWithNotSameDay() {
        Date date1 = new Date(1, 1, 2016);
        Date date2 = new Date(2, 1, 2016);
        assertFalse(date1.equals(date2));
    }

    @Test
    public void testEqualsWithSameObject() {
        Date date1 = new Date(1, 1, 2016);
        assertTrue(date1.equals(date1));
    }

    @Test
    public void testEqualsWithNull() {
        Date date1 = new Date(1, 1, 2016);
        Date date2 = null;
        assertFalse(date1.equals(date2));
    }

    @Test
    public void testEqualsWithDifferentClass() {
        Date date1 = new Date(1, 1, 2016);
        assertFalse(date1.equals(3));
    }

    @Test
    public void testIsValideDateWithDay0() {
        assertFalse(Date.isValidDate(0, 1, 2016));
    }

    @Test
    public void testIsValideDateWithDay32() {
        assertFalse(Date.isValidDate(32, 1, 2016));
    }

    @Test
    public void testIsValideDateWithMonth0() {
        assertFalse(Date.isValidDate(1, 0, 2016));
    }

    @Test
    public void testIsValideDateWithMonth13() {
        assertFalse(Date.isValidDate(1, 13, 2016));
    }

    @Test
    public void testIsValideDateWithYearlowerThan0() {
        assertFalse(Date.isValidDate(1, 1, -500));
    }

    @Test
    public void testIsValideDateWithMonth2Day29AndNotLeapYear() {
        int notLeapYear = 401; // 401 % 4 = 1 and 401 % 100 = 1 and 401 % 400 = 1
        assertFalse(Date.isValidDate(29, 2, notLeapYear));
    }

    @Test
    public void testIsValideDateWithMonth2Day28AndNotLeapYear() {
        int notLeapYear = 401; // 401 % 4 = 1 and 401 % 100 = 1 and 401 % 400 = 1
        assertTrue(Date.isValidDate(28, 2, notLeapYear));
    }

    @Test
    public void testIsValideDateWithMonth2Day29AndLeapYear() {
        int leapYear = 400; // 400 % 4 = 0 and 400 % 100 = 0 and 400 % 400 = 0
        assertTrue(Date.isValidDate(29, 2, leapYear));
    }

    @Test
    public void testIsValideDateWithMonth2Day30AndLeapYear() {
        int leapYear = 400; // 400 % 4 = 0 and 400 % 100 = 0 and 400 % 400 = 0
        assertFalse(Date.isValidDate(30, 2, leapYear));
    }

    @Test
    public void testIsValideDateWithAllthirtyDaysMonthWith30Days() {
        boolean isValid = true;
        int[] month30Days = {4, 6, 9, 11};
        for (int month : month30Days) {
            if (!Date.isValidDate(30, month, 2016)) {
                isValid = false;
                break;
            }
        }
        assertTrue(isValid);
    }

    @Test
    public void testIsValideDateWithAllthirtyDaysMonthWith31Days() {
        boolean isValid = true;
        int[] thirtyDaysMonths = {4, 6, 9, 11}; // April, June, September, November
        for (int month : thirtyDaysMonths) {
            if (Date.isValidDate(31, month, 2016)) {
                isValid = false;
                break;
            }
        }
        assertTrue(isValid);
    }

    @Test
    public void testIsValideDateWithAllthirtyOneDaysMonthWith31Days() {
        boolean isValid = true;
        int[] thirtyOneDaysMonths = {1, 3, 5, 7, 8, 10, 12}; // January, March, May, July, August, October, December
        for (int month : thirtyOneDaysMonths) {
            if (!Date.isValidDate(31, month, 2016)) {
                isValid = false;
                break;
            }
        }
    }

    @Test
    public void testIsValideDateWithAllthirtyOneDaysMonthWith32Days() {
        boolean isValid = true;
        int[] thirtyOneDaysMonths = {1, 3, 5, 7, 8, 10, 12}; // January, March, May, July, August, October, December
        for (int month : thirtyOneDaysMonths) {
            if (Date.isValidDate(32, month, 2016)) {
                isValid = false;
                break;
            }
        }
        assertTrue(isValid);
    }


}