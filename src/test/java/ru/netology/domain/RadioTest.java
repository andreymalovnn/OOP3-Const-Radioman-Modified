package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    // Тестирование выбора и настройки радиостанций:
    @ParameterizedTest
    @CsvSource({"5,5", "1,1", "9,9", "-1,0", "0,0", "10,0"})
    void shouldTuneStation(int currentStation, int expected) {
        Radio station = new Radio();
        station.setCurrentStation(currentStation);
        int actual = station.getCurrentStation();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"1,2", "5,6", "8,9", "9,0", "0,1"})
    void shouldTuneStationUpAndOver(int currentStation, int expected) {
        Radio tuneUp = new Radio();
        tuneUp.setCurrentStation(currentStation);
        tuneUp.next();
        int actual = tuneUp.getCurrentStation();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"9,8", "5,4", "2,1", "1,0", "0,9"})
    void shouldTuneStationDownAndOver(int currentStation, int expected) {
        Radio tuneDown = new Radio();
        tuneDown.setCurrentStation(currentStation);
        tuneDown.prev();
        int actual = tuneDown.getCurrentStation();
        assertEquals(actual, expected);
    }


    // Тестирование выбора и настройки уровня громкости:
    @ParameterizedTest
    @CsvSource({"7,7", "1,1", "10,10", "-1,0", "0,0", "11,0"})
    void shouldTuneVolume(int currentVolume, int expected) {
        Radio volume = new Radio();
        volume.setCurrentVolume(currentVolume);
        int actual = volume.getCurrentVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "5,6", "10,10"})
    void shouldIncreaseVolumeToMax(int currentVolume, int expected) {
        Radio volumeUp = new Radio();
        volumeUp.setCurrentVolume(currentVolume);
        volumeUp.increaseVolume();
        int actual = volumeUp.getCurrentVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"10,9", "6,5", "1,0", "0,0"})
    void shouldDecreaseVolumeToMin(int currentVolume, int expected) {
        Radio volumeDown = new Radio();
        volumeDown.setCurrentVolume(currentVolume);
        volumeDown.decreaseVolume();
        int actual = volumeDown.getCurrentVolume();
        assertEquals(actual, expected);
    }

}