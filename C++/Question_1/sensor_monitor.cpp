#include<iostream>
#include<cstdlib>
using namespace std;

int main(int argc, char* argv[]){

    if(argc != 4){
        cout << "Usage : ./sensor_monitor <warn_threshold> <critical_threshold> <num_readings>" << endl;
        cout << "Error  : Missing arguments." << endl;
        return 1;
    }

    int warn = stoi(argv[1]);
    int critical = stoi(argv[2]);
    int num_readings = stoi(argv[3]);

    if(warn >= critical || num_readings <= 1 || num_readings >= 500){
        cout << "Error : Invalid arguments." << endl;
        return 1;
    }

    int normal = 0;
    int warning = 0;
    int criticalCount = 0;
    int shutdown = 0;

    for(int i = 0; i < num_readings; i++){

        int temp = rand() % 70;

        if(temp < warn){
            normal++;
        }
        else if(temp < critical){
            warning++;
        }
        else if(temp < 60){
            criticalCount++;
        }
        else{
            shutdown++;
        }
    }

    cout << "Config  : Warn=" << warn
         << " C  Critical=" << critical
         << " C  Readings=" << num_readings << endl;

    cout << "Results : Normal:" << normal
         << "  Warning:" << warning
         << "  Critical:" << criticalCount
         << "  Shutdown:" << shutdown << endl;

    return 0;
}