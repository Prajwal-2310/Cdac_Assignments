#include<iostream>
using namespace std;

void resetSensorPairV1(int reading1, int reading2){

    reading1 = reading1 + reading2;
    reading2 = reading1 - reading2;
    reading1 = reading1 - reading2;

}

void resetSensorPairV2(int& reading1, int& reading2){
    reading1 = reading1 + reading2;
    reading2 = reading1 - reading2;
    reading1 = reading1 - reading2;

}
void resetSensorPairV3(int* reading1, int* reading2){
    *reading1 = *reading1 + *reading2;
    *reading2 = *reading1 - *reading2;
    *reading1 = *reading1 - *reading2;
}

int main(){
    cout << "Enter The Sensor A Reading : ";
    int A;
    cin >> A;

    cout << "Enter The Sensor B Reading : ";
    int B;
    cin >> B;

    cout << "--- V1: Call by Value ---"<<endl;
    cout<<"Before : A = "<<A<<" B = "<<B<<endl;
    resetSensorPairV1(A , B);
    cout<<"After :  A = "<<A<<" B = "<<B<<"\t <- Value Unchanged"<<endl;
    cout<<endl;

    cout << "--- V2: Call by Reference ---"<<endl;
    cout<<"Before : A = "<<A<<" B = "<<B<<endl;
    resetSensorPairV2(A , B);
    cout<<"After :  A = "<<A<<" B = "<<B<<"\t <- Value Changed"<<endl;
    cout<<endl;

    cout << "--- V3: Call by Pointer ---"<<endl;
    cout<<"Before : A = "<<A<<" B = "<<B<<endl;
    resetSensorPairV3(&A , &B);
    cout<<"After :  A = "<<A<<" B = "<<B<<"\t <- Values Swapped Back"<<endl;
    cout<<endl;

    return 0;
}