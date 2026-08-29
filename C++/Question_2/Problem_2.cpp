#include<iostream>
#include<cmath>;
using namespace std;

double computeRMS(double* signal, int n){
    
    double sum = 0;
    for(int i=0; i<n; i++){
       sum = sum + (pow(*(signal+i),2));
    }
    return sqrt(sum/n);
}

void normalise(double* signal, int n){

    double max = 0;

    for(int i = 0; i < n; i++){
        if(abs(*(signal + i)) > max){
            max = abs(*(signal + i));
        }
    }

    for(int i = 0; i < n-1; i++){
        *(signal + i) = *(signal + i) / max;
    }
}

int countZeroCrossings(double* signal, int n){
    int count = 0;
    for(int i=0; i<n; i++){
        if((*(signal + i)>0  && *(signal + (i+1))<0 || 
        ( *(signal + i)<0)  && *(signal + (i+1))>0 )){
            count++;
        }
    }
    return count;
}

void applyGain(double* signal, int n, double gainFactor){
    for(int i=0; i<n; i++){
        *(signal + i) = *(signal + i) * gainFactor;
    }
}

int main(){

    double arr[7] = {0.5, -1.2, 0.8, -0.3, 1.0, -0.9, 0.1};

    double rms = computeRMS(arr, 7);
    cout <<"The  RMS value is : "<<rms<<endl;
    cout<<"--------------------------------------------------------------------------------"<<endl;

    normalise(arr, 7);
    cout <<"After Normalizing the Reading : "<<endl;
    for(int i = 0; i < 7; i++){
        cout << *(arr + i) << " ";
    }
    cout<<endl;
    cout<<"--------------------------------------------------------------------------------"<<endl;


    int count = countZeroCrossings(arr, 7);
    cout << "The count of  positions where adjacent elements have opposite signs is : "<<count<<endl;
    cout<<"--------------------------------------------------------------------------------"<<endl;


    applyGain(arr, 7, 2);
    cout<<"After Gain "<<endl;
    for(int i=0; i<7; i++){
        cout<<*(arr + i)<<" ";
    }

}