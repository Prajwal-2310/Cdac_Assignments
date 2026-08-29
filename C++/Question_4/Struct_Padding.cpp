#include<iostream>
using namespace std;

struct Layout1 {
    char c1;
    int i;
    char c2;
};

struct Layout2 {
    int i;
    char c1;
    char c2;
};

int main(){

    cout << "Size of Layout1 : " << sizeof(Layout1) << " bytes" << endl;
    cout << "Size of Layout2 : " << sizeof(Layout2) << " bytes" << endl;

    /*
    1. The sizes of Layout1 and Layout2 can differ because the compiler
       adds padding between members to satisfy memory alignment requirements.

    2. Padding is extra unused memory added by the compiler between or
       after structure members so that the data members are properly aligned.

    3. Member order matters because changing the order can change the amount
       of padding and therefore the total size of the structure. This is
       important when defining network packet headers or hardware register
       maps where the exact memory layout matters.
    */

    return 0;
}