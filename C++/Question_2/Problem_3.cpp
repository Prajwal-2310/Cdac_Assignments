#include<iostream>
using namespace std;


int main(){
    int statusReg  = 0b10110001;
    int controlReg = 0b00000000;
    int dataReg    = 0b11001010;

    const int *regPtr1 = &statusReg;
    cout<<"Status Register : "<<*regPtr1<<endl;

    //*regPtr1 = 10;
    // error: assignment of read-only location '* regPtr1'
    // Here The location where pointer is pointing is constant
    //It is Pointer to Constant integer and beacause of this we can not change the original value


    int* const regPtr2 = &controlReg;

    *regPtr2 = 30;
    cout << "After changing the Value of Control Register : "<<*regPtr2 << endl;

    // regPtr2 = &dataReg;
    // Error : You can not change the adsress stored int the regPtr2
    // Beacuse here the pointer is itself as constant

    const int* const regPtr3 = &statusReg;
    cout << "Status Register : "<<*regPtr3<<endl;;

    // *regPtr3 = 20;
    // error: assignment of read-only location '* regPtr'

    // regPtr3 = &dataReg;
    // Error : You can not change the adsress stored int the regPtr2

    // Here it is beacuse both the pointer and variable are constant
    
}