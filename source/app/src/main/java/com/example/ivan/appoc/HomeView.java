package com.example.ivan.appoc;

import com.example.ivan.appoc.HomeView;
import com.example.ivan.appoc.Location;

public interface HomeView {
    void warnWasNotPossibleToCaptureLocation(String errorMessage);

    void show(Location location, ActivityType activityType);

    void warnWasNotPossibleToRecognizeActivity(String errorMessage);

    void warnTracking();

    void warnTrackingHasBeenStopped();

    void showStopButton();

    void showPlayButton();
}
