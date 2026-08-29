#include<iostream>
#include<cmath>
using namespace std;

inline double distanceBetween(double x1, double y1, double x2, double y2){
    return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

inline double toRadians(double degrees){
    return degrees * (M_PI / 180.0);
}

inline double clamp(double value, double minVal, double maxVal){
    if(value > maxVal){
        return maxVal;
    }else if(value < minVal){
        return minVal;
    }else{
        return value;
    }
}

inline bool isInSafeZone(double x, double y, double cx, double cy, double radius){
    
    double distance = distanceBetween(x, y, cx, cy);

    return distance <= radius;

}

int main(){

    double homeX = 0.0;
    double homeY = 0.0;
    double radius = 50.0;

    double x1 = 10.3;
    double y1 = 23.6;

    double x2 = 15.3;
    double y2 = 33.6;

    double x3 = 40.3;
    double y3 = 17.6;

    double distance1 = distanceBetween(homeX, homeY, x1, y1);
    double distance2 = distanceBetween(homeX, homeY, x2, y2);
    double distance3 = distanceBetween(homeX, homeY, x3, y3);

    cout << "Waypoint 1 : (" << x1 << ", " << y1 << ")" << endl;
    cout << "Distance from home : " << distance1 << endl;
    cout << "Inside safe zone   : "
         << (isInSafeZone(x1, y1, homeX, homeY, radius) ? "Yes" : "No")
         << endl << endl;

    cout << "Waypoint 2 : (" << x2 << ", " << y2 << ")" << endl;
    cout << "Distance from home : " << distance2 << endl;
    cout << "Inside safe zone   : "
         << (isInSafeZone(x2, y2, homeX, homeY, radius) ? "Yes" : "No")
         << endl << endl;

    cout << "Waypoint 3 : (" << x3 << ", " << y3 << ")" << endl;
    cout << "Distance from home : " << distance3 << endl;
    cout << "Inside safe zone   : "
         << (isInSafeZone(x3, y3, homeX, homeY, radius) ? "Yes" : "No")
         << endl;

    return 0;

}
