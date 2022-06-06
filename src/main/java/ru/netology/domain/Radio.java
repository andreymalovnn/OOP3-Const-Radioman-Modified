package ru.netology.domain;

public class Radio {
    private int numberOfStations = 10;
    private int minStation;
    private int currentStation;

    private int minVolume;
    private int maxVolume = 100;
    private int currentVolume;

    // Выбор количества радиостанций и настройки станции:
    public Radio() {
    }

    public Radio(int numberOfStations) {
        this.numberOfStations = numberOfStations;
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation) {
            return;
        }
        if (currentStation > numberOfStations - 1) {
            return;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void next() {
        if (currentStation < numberOfStations - 1) {
            currentStation = currentStation + 1;
        } else currentStation = 0;
    }

    public void prev() {
        if (currentStation > minStation) {
            currentStation = currentStation - 1;
        } else currentStation = numberOfStations - 1;
    }


    // Выбор и настройка уровня громкости:
    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minVolume) {
            return;
        }
        if (currentVolume > maxVolume) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        } else currentVolume = maxVolume;
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        } else currentVolume = minVolume;
    }

}
