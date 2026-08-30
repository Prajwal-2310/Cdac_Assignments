#include<iostream>
using namespace std;

int main(){
    cout <<"Enter the number of Rows : ";
    int R;
    cin >>R;

    cout <<"Enter the number of Columns : ";
    int C;
    cin >> C;


    int **arr = new int*[R];
    for(int i=0; i<R; i++){
        arr[i] = new int [C];
    }

    cout << "Enter the Values : 0=Grass  1=Water  2=Mountain  3=Forest  4=Dungeon"<<endl;
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            cin >> arr[i][j];
        }
    }

    cout << "\n===== GAME MAP (" << R << " x " << C << ") =====" << endl;
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            cout<<"   "<<arr[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;
    cout << "Legend : 0=Grass  1=Water  2=Mountain  3=Forest  4=Dungeon"<<endl;
    int grass = 0;
    int water = 0; 
    int mountain = 0;
    int forest = 0;
    int dungeon = 0;


    for(int i=0; i<R;i++){
        for(int j=0; j<C; j++){
            if(arr[i][j] == 0){
                grass++;
            }else if(arr[i][j] == 1){
                water++;
            }else if(arr[i][j] == 2){
                mountain++;
            }else if(arr[i][j] == 3){
                forest++;
            }else if(arr[i][j] == 4){
                dungeon++;
            }
        }
    }

    cout <<endl;
    cout << "Tital Count : "<<endl;
    cout <<"   Grass    : "<<grass<<endl;
    cout <<"   Water    : "<<water<<endl;
    cout <<"   Mountain : "<<mountain<<endl;
    cout <<"   Forest   : "<<forest<<endl;
    cout <<"   Dungeon  : "<<dungeon<<endl;


    for(int i=0; i<R; i++){
        delete arr[i];
    }
    delete[] arr;

    return 0;
}