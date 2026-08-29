#include<iostream>
using namespace std;

int main(){

    cout << "Enter the number of readings: ";
    int N;
    cin >> N;

    if(N < 1 || N > 100){
        cout << "Readings are only between 1 to 100";
        return 0;
    }

    cout << "Readings entered : " << N << endl;

    double arr[100];

    cout << "Enter the readings: ";

    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }

    int skip = 0;

    cout << "Valid readings : ";

    for(int i = 0; i < N; i++){

        if(arr[i] < 0){
            skip++;
            continue;
        }

        cout << arr[i] << " ";
    }

    cout << endl;
    cout << "Skipped (errors) : " << skip << endl;

    for(int i = 0; i < N; i++){

        if(arr[i] >= 45){
            cout << "First CRITICAL : Index " << i << " -> " << arr[i] << " C" << endl;
            break;
        }
    }

    double min = 0;
    double max = 0;
    double sum = 0;

    int normal = 0;
    int warning = 0;
    int critical = 0;
    int shutdown = 0;

    bool firstValid = true;

    for(int i = 0; i < N; i++){

        if(arr[i] < 0){
            continue;
        }

        if(firstValid){
            min = arr[i];
            max = arr[i];
            firstValid = false;
        }

        if(arr[i] < min){
            min = arr[i];
        }

        if(arr[i] > max){
            max = arr[i];
        }

        sum = sum + arr[i];

        if(arr[i] < 30){
            normal++;
        }
        else if(arr[i] < 45){
            warning++;
        }
        else if(arr[i] < 60){
            critical++;
        }
        else{
            shutdown++;
        }
    }

    double average = sum / (N - skip);

    cout << "Min : " << min << "  C" << "    Max : " << max << " C" << "    Avg : " << average << " C" << endl;

    cout << "Normal : " << normal << "    Warning : " << warning<< "    Critical : " << critical
    << "    Shutdown : " << shutdown << endl;

    return 0;
}