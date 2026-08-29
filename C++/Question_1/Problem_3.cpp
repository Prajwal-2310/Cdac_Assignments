#include<iostream>
using namespace std;

int main(){
    double arr[3][3];

    for(int i=0; i<3; i++){
        cout<<"Enter the temprature of floor: "<<i+1<<endl;
        for(int j=0; j<3; j++){
            cout<<"Enter the temprature of room: "<<j+1<<endl;
            cin >> arr[i][j];
        }
    }
    cout << "\tRoom1\tRoom2\tRoom3" << endl;
    cout <<endl;
    for(int i=0; i<3; i++){
        cout<<"Floor"<<i+1;
        for(int j=0; j<3; j++){
            cout << "\t"<<arr[i][j];
        }
        cout<<endl;
    }

    double temp = arr[0][0];
    int hottestFloor = 0;
    int hottestRoom = 0;
    double Floor1 = 0; 
    double Floor2 = 0; 
    double Floor3 = 0; 
    double avg1;
    double avg2;
    double avg3;
    int i,j;
    for( i=0; i<3; i++){
        for( j=0; j<3; j++){
            if(arr[i][j] > temp){
                temp = arr[i][j];
                hottestFloor = i;
                hottestRoom = j;
            }
            if(i == 0 && (j == 0 || j==1 || j==2)){
                Floor1 = Floor1 + arr[i][j];
                avg1 = (Floor1 / 3);
            }else if(i == 1 && (j == 0 || j==1 || j==2)){
                Floor2 = Floor2 + arr[i][j];
                avg2 = (Floor2 / 3);
            }else if(i == 2 && (j == 0 || j==1 || j==2)){
                Floor3 = Floor3 + arr[i][j];
                avg3 = (Floor3 / 3);
            } 
        }
    }

    cout<<"Hottest Room : Floor "<<hottestFloor+1<<" Room "<<hottestRoom+1<<" -> "<<temp<<" C"<<endl;
    if(avg1 > avg2 && avg1 > avg3){
        cout << "Hottest Floor : Floor 1 (avg "<<avg1<<" C)"<<endl;
    }else if(avg2 > avg1 && avg2 > avg3){
        cout << "Hottest Floor : Floor 2 (avg "<<avg2<<" C)"<<endl;
    }else if(avg3 > avg1 && avg3 > avg2){
        cout << "Hottest Floor : Floor 3 (avg "<<avg3<<" C)"<<endl;
    }

    int count = 0;
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            if(arr[i][j] > 30){
                count++;
            }
        }
    }
    cout << "Rooms at Warning  or above : "<<count<<endl;

    

    




}