#include<iostream>
#include<memory>
using namespace std;

class AudioClip{
    string audioClip;
    double freq;

    public:
    AudioClip(string audioClip, double freq) : audioClip(audioClip), freq(freq){

    }

    string getaudioClip(){
        return audioClip;
    }
};

int main(){
    shared_ptr<AudioClip> audio = make_shared<AudioClip>("explosion", 3.5);
    weak_ptr<AudioClip> observer = audio;

    if(auto clip = observer.lock()){
        cout << "Clip Alive : "<< clip->getaudioClip()<<endl;
    }

    audio.reset();

    if(observer.expired()){
        cout <<"Clip Already Unlocked"<<endl;
    }

    return 0;
}