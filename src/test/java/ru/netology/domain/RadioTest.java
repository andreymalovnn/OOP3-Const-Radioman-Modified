package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RadioTest {

    // Тестирование выбора количества радиостанций и настройки станции:
    @Test
    void shouldSetDefaultNumberOfStations() {
        Radio radio = new Radio();
        int actual = radio.getNumberOfStations();
        assertEquals(10, actual);
    }

    @Test
    void shouldSetMoreNumberOfStations() {
        Radio radio = new Radio(20);
        int actual = radio.getNumberOfStations();
        assertEquals(20, actual);
    }

    @ParameterizedTest
    @CsvSource({"-1,0", "0,0", "1,1", "5,5", "8,8", "9,9", "10,0"})
    void shouldTuneStation(int currentStation, int expected) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"-1,0", "0,0", "1,1", "15,15", "28,28", "29,29", "30,0"})
    void shouldTuneMoreStations(int currentStation, int expected) {
        Radio radio = new Radio(30);
        radio.setCurrentStation(currentStation);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "14,15", "28,29", "29,0"})
    void shouldTuneStationUpAndOver(int currentStation, int expected) {
        Radio radio = new Radio(30);
        radio.setCurrentStation(currentStation);
        radio.next();
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"39,38", "38,37", "20,19", "1,0", "0,39"})
    void shouldTuneStationDownAndOver(int currentStation, int expected) {
        Radio radio = new Radio(40);
        radio.setCurrentStation(currentStation);
        radio.prev();
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }


    // Тестирование выбора и настройки уровня громкости:
    @ParameterizedTest
    @CsvSource({"-1,0", "0,0", "1,1", "50,50", "99,99", "100,100", "101,0"})
    void shouldTuneVolume(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        int actual = radio.getCurrentVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "55,56", "98,99", "100,100"})
    void shouldIncreaseVolumeToMax(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @CsvSource({"100,99", "99,98", "50,49", "1,0", "0,0"})
    void shouldDecreaseVolumeToMin(int currentVolume, int expected) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();
        assertEquals(actual, expected);
    }

}