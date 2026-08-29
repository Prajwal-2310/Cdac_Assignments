#include<iostream>
using namespace std;

bool parsePacket(const  int* rawData, int size, int** outMin, int** outMax){

    if(size <=0){
        return false;
    }

    const int *minPtr = rawData;
    const int *maxPtr = rawData;

    for(int i=0; i<size; i++){
        if(*(rawData + 1) < *minPtr){
            minPtr = rawData +1;
        }

        if(*(rawData +1 ) > *maxPtr){
            maxPtr = rawData+1;
        }
    }

    *outMin = const_cast<int*>(minPtr); // const_cast is used to remove or add the const keyword
    *outMax = const_cast<int*>(maxPtr);

    return true;
}

int main(){
    int packet[] = {45, 12, 67, 8, 55, 31};
    int* minPtr = nullptr;
    int* maxPtr = nullptr;
    if (parsePacket(packet, 6, &minPtr, &maxPtr)) {
        cout << "Calibration Min : " << *minPtr << endl;
        cout << "Calibration Max : " << *maxPtr << endl;
    }
}