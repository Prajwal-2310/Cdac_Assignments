#include<iostream>
using namespace std;

class Entity{

    private:
    string name;
    int health;
    int level;
    string type;

    public:
    Entity& setName(const string& name){
        this -> name = name;
        return *this;
    }
    Entity& setHealth(int health){
        this -> health = health;
        return *this;
    }
    Entity& setLevel(int level){
        this -> level = level;
        return *this;
    }
    Entity& setType(const string& type){
        this -> type = type;
        return *this;

    }

    string getName() const{
        return name;
    }
    int getHealth() const{
        return health;
    }
    int getLevel() const{
        return level;
    }
    string getType() const{
        return type;
    }


    void displayInfo() const{
        cout << "Name    : " <<name<<endl;
        cout << "Health  : "<<health<<endl;
        cout << "Level   : " <<level<<endl;
        cout << "Type    : " <<type<<endl;
    }



};


namespace Physics {
    double clamp(double val, double min, double max){
        if(val < min){
            return min;
        }

        if(val > max){
            return max;
        }
    }
    double lerp(double a, double b, double t){
         return a + (b - a) * t;
    }       
}

namespace GameMath {
    int clamp(int val, int min, int max){
        if(val < min){
            return min;
        }

        if(val > max){
            return max;
        }
    }              
    double lerp(double a, double b, double t){
        return a + (b - a) * t;
    }       
}




int main(){


    Entity player, enemy, item;
    player.setName("Aragorn").setHealth(100).setLevel(10).setType("Player");
    enemy.setName("Orc").setHealth(60).setLevel(5).setType("Enemy");
    item.setName("HealthPotion").setHealth(0).setLevel(1).setType("Item");

    
    player.displayInfo();
    cout <<"====================================================================="<<endl;
    enemy.displayInfo();
    cout <<"====================================================================="<<endl;
    item.displayInfo();
    cout <<"====================================================================="<<endl;

    cout << "Physics Clamp : "<<Physics::clamp(120.0,0,100)<<endl;
    cout << "GameMath Clamp : "<< GameMath::clamp(120, 0, 100) << endl;
    cout << "Physics Lerp : "<< Physics::lerp(0, 100, 0.5) << endl;
    cout << "GameMath Lerp : "<< GameMath::lerp(10, 20, 0.25) << endl;

    cout <<"====================================================================="<<endl;

    {
    using namespace Physics;

    cout << "Physics Clamp Using namespace demaonstration : "<<clamp(150.5, 0, 100) << endl;
    cout << "Physics lerp Using namespace demaonstration : "<<lerp(0, 100, 0.5) << endl;

    }



    return 0;
}