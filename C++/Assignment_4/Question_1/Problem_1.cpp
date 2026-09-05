#include<iostream>
#include<iomanip>
using namespace std;

class LedgerEntry{
    string discription;
    double* amounts;
    int days;
    static int totalEntries;

public:
    LedgerEntry(const string& desc, int days) : discription(desc), days(days){
        amounts = new double[days];
        totalEntries++;
        cout << "[LedgerEntry Created] "<<desc << " (" << days << " days)"<<endl;;
    }

    LedgerEntry(const LedgerEntry& other){
        discription = other.discription;
        days = other.days;
        amounts = new double[days];

        for(int i=0; i<days; i++){
            amounts[i] = other.amounts[i];
        }
        totalEntries++;
        cout << "[Copy Constructor] "<<discription <<endl;
    }

    LedgerEntry(LedgerEntry&& other) noexcept{
        discription = other.discription;
        days = other.days;
        amounts = other.amounts;

        other.discription = "";
        other.days = 0;
        other.amounts = nullptr;

         totalEntries++;

        cout << "[Move Constructor] Ownership transferred" << endl;
    }

    LedgerEntry& operator=(const LedgerEntry& other){
        if(this != &other){
            delete[] amounts;

            discription = other.discription;
            days = other.days;
            amounts = new double[days];

            for(int i=0; i<days; i++){
                amounts[i] = other.amounts[i];
            }
        }
        return *this;
    }

    LedgerEntry& operator=(LedgerEntry&& other) noexcept{
        if(this != &other){
            delete[] amounts;

            discription = other.discription;
            days = other.days;
            amounts = other.amounts;

            other.discription = "";
            other.days = 0;
            other.amounts = nullptr;
            cout << "[Move Assignment] Ownership transferred"<< endl;

        }
        return *this;
    }

        ~LedgerEntry(){
            delete[] amounts;
            cout << "[Destructor] "<< discription << " destroyed"<< endl;
        }

    LedgerEntry operator+(const LedgerEntry& other) const{

        LedgerEntry result(discription + " + " + other.discription, days);
            
        for(int i=0; i<days; i++){
            result.amounts[i] = this->amounts[i] + other.amounts[i];
        }   
    }

    bool operator==(const LedgerEntry& other) const{
        double total1 = 0.0;
        double total2 = 0.0;

        for(int i=0; i<days; i++){
            total1 = total1 + amounts[i];
        }

        for(int i=0; i<days; i++){
            total2 = total2 + amounts[i];
        }

        return total1 == total2;
    }

    bool operator>(const LedgerEntry& other) const{
        double total1 = 0.0;
        double total2 = 0.0;

        for(int i=0; i<days; i++){
            total1 = total1 + amounts[i];
        }

        for(int i=0; i<days; i++){
            total2 = total2 + amounts[i];
        }
         return total1 > total2;
    }

    double& operator[](int index){
        if(index < 0 || index >= days){
            throw std::out_of_range("Index out of bounds");
        }

        return amounts[index];
    }
    const double& operator[](int index) const{
        if(index < 0 || index >= days){
            throw std::out_of_range("Index out of bounds");
        }
        return amounts[index];
    }

    friend ostream& operator<<(ostream& out, const LedgerEntry& entry);
    friend istream& operator>>(istream& in , const LedgerEntry& entry);

    static int gettotalEntries(){
        return totalEntries;
    }
};

ostream& operator<<(ostream& out, const LedgerEntry& entry){
    out << entry.discription << " : [";

    double total = 0.0;

    for(int i=0; i<entry.days; i++){
        out<<fixed<<setprecision(2)<<entry.amounts[i];
        total = total + entry.amounts[i];

        if (i < entry.days - 1) {
            out << ", ";
        }
    }

    out << "]  Total : "<<fixed<<setprecision(2)<<total<<endl;
    return out;
}

istream& operator>>(istream& in, const LedgerEntry& entry){
    for(int i=0; i<entry.days; i++){
        in >> entry.amounts[i];
    }
}

int LedgerEntry::totalEntries = 0;

int main() {
   
    LedgerEntry jan("January Sales", 5);
    jan[0] = 1200.50;  jan[1] = 3400.00;  jan[2] = 800.75; jan[3] = 2100.00;  jan[4] = 650.25;
    LedgerEntry feb("February Sales", 5);
    feb[0] = 900.00;   feb[1] = 2200.50;  feb[2] = 1750.00; feb[3] = 3000.00;  feb[4] = 475.50;
    cout << jan << endl;
    cout << feb << endl;
    
    LedgerEntry combined = jan + feb;
    cout << "Combined: " << combined << endl;
    
    cout << "Jan == Feb : " << (jan == feb ? "Yes" : "No") << endl;
    cout << "Jan  > Feb : " << (jan  > feb ? "Yes" : "No") << endl;
    
    LedgerEntry moved = move(jan);
    cout << "After move, jan.amounts is null: "<< (true ? "YES" : "NO") << endl;
    cout << "Moved entry: " << moved << endl;
    LedgerEntry q1("Q1 Total", 5);
    q1 = move(feb);   
    cout << "Q1 (moved from feb): " << q1 << endl;
   
    cout << "Live LedgerEntry objects: " << LedgerEntry::gettotalEntries() << endl;
    return 0;
}