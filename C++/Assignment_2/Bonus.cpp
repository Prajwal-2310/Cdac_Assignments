#include<iostream>
#include<string>
using namespace std;

int level = 1;

namespace Engine{

    namespace Audio{
        void playSound(string name){
            cout <<"Playing : "<<name<<endl;
        }
    }
}

int main(){
    int level = 10;

    cout <<"Local Variable : "<<level<<endl;
    cout <<"Global Variable : "<<::level<<endl;

    Engine::Audio::playSound("Sword_Clash");

    return 0;
}