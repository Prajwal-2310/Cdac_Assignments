#include<iostream>
#include <memory>
using namespace std;

class Texture{

    string name;
    int width;
    int height;

public: 
    Texture(string name, int width, int height): name(name), width(width), height(height){
        cout<<"Tecture Loaded"<<endl;
    }

    void display()const{
        cout <<"Width : "<<this->width<<endl;
        cout <<"Height : "<<this->height<<endl;
    }

    ~Texture(){
        cout<<"Texture Released..."<<endl;
    }
};


int main(){

    unique_ptr<Texture> texture = make_unique<Texture>("player_sprite", 512,512);
    texture->display();

//    unique_ptr<Texture> texture1 = texture;  Bunique_ptr cannot be copied because it allows only one owner of an object, preventing double deletion and dangling-pointer problems. 
                        
   unique_ptr<Texture> texture1 = move(texture);
   cout << "texture is null: " << (texture == nullptr ? "YES" : "NO") << endl;
}