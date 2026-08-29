#include<iostream>
using namespace std;


int main(){
    cout <<"Enter the temprature: ";
    double temp;
    cin >> temp;

    double fahren = (temp * 9 / 5) + 32;

    int status_code;
    if(temp < 0){
       status_code = -1;
    }else if(temp >=0 && temp <= 29){
        status_code = 0;
    }else if(temp >=30 && temp <= 44){
        status_code = 1;
    }else if(temp >=45 && temp <= 59){
        status_code = 2;
    }else if(temp >= 60){
        status_code = 3;
    }


    cout << "Temperature = " <<temp<< " C"" / " <<fahren<<" F"<<endl;

    switch(status_code){
        case -1:
            cout << "Status =  SENSOR_ERROR"<<endl;
            cout << "Action = Sensor Fault - Check Wring"<<endl;
            break;

        case 0:
            cout << "Status =  NORMAL"<<endl;
            cout << "Action = No Action Required"<<endl;
            break;

        case 1:
            cout << "Status =  WARNING"<<endl;
            cout << "Action = Alert Sent to Supervisor"<<endl;
            break;

        case 2:
            cout << "Status =  CRITICAL"<<endl;
            cout << "Action = Cooling System Triggered"<<endl;
            break;

        case 3:
            cout << "Status =  SHUTDOWN"<<endl;
            cout << "Action = Emergency shutdown initiated"<<endl;
            break;

        default:
            cout << "Enter the valis Status_Code"<<endl;

    }

    cout << ((temp <= 25) ? "Below Average" : "Above Average");
    
}