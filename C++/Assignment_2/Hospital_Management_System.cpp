#include<iostream>
using namespace std;

class Patient{

    private:
    int patientId;
    string name;
    int age;
    string ward;
    const string bloodGroup;

    public:
    Patient() : bloodGroup("O+"){
        patientId = 0;
        name = "Unknown"; 
        age=0;
        ward="General"; 
        cout << "Default patient registered"<<endl; 
    }

    Patient(int Id, string patientName) : bloodGroup("O+"){
        patientId = Id;
        name = patientName;
        age = 0;
        ward = "General";
        cout << "Emergency : " << name<<endl;
    }

    Patient(int id, string patientName, int agee, string section, string bg) : bloodGroup(bg){
        patientId = id;
        name = patientName;
        age = agee;
        ward = section;

        cout << "Full Admission : "<<name<<endl;
    }

    ~Patient(){
        cout << "[Destructor] Patient "
             << name << " discharged." << endl;
    }

    void displayRecord()const{
        cout << "Patient Record : "<<endl;
        cout <<"\tID         : "<<patientId<<endl;
        cout <<"\tName       : "<<name<<endl;
        cout <<"\tAge        : "<<age<<endl;
        cout <<"\tWard       : "<<ward<<endl;
        cout <<"\tBlood Grp  : "<<bloodGroup<<endl;
    }

    void transferWard(const string& name ,const string& newWard){
        cout << "Ward Transfer : " <<name <<" -> "<<newWard<<endl;

        ward = newWard;
    }

    
};


int main(){
    Patient P2(1002, "Nakul Patil", 22, "Cardiology", "O-");
    Patient P1(1001, "Manish Singh");
    Patient P3;

    P2.displayRecord();
    cout<<endl;
    P1.displayRecord();
    cout<<endl;
    P3.displayRecord();
    cout<<endl;

    Patient *P = new Patient[2];

    for(int i=0; i<2; i++){
        P[i].displayRecord();
        cout<<endl;
        
    }

    P[0].transferWard("Manish Singh","ICU");
    cout<<endl;
    delete[] P;

    return 0;
}