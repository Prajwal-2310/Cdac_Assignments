#include<iostream>
#include<vector>
using namespace std;

class Vehicle{
    protected: 
        string registrationNo;
        string ownerName;
        int yearOfManufacture;
        double kmDriven;

    public: 
        //Vehicle(){}
        Vehicle(string No, string name, int year, double km) : registrationNo(No), ownerName(name), yearOfManufacture(year), kmDriven(km){
            cout <<"[Vehicle Constructor]"<<No<<" : "<<name<<endl;
        }

        virtual double fuelCost(double kmToTravel) const = 0;
        virtual void describe() const{
            cout<< "RegistrationNo " <<registrationNo<<endl;
            cout<<"OwenerName : "<<ownerName<<endl;
            cout<<"Year of Manufacture : "<<yearOfManufacture<<endl;
            cout<<"Km Driven : "<<kmDriven<<endl;

        }

        virtual string vehicleType() const = 0;
        virtual ~Vehicle(){
            cout<<"[Vehicle Destructor] "<<registrationNo<<endl;
        }

        double getKmDriven() const{
            return kmDriven;
        }

        string getRegNo() const{
            return registrationNo;
        }

};

class Car : public Vehicle{
    protected:
        string fuelType;
        double mileageKmpl;
        double fuelPricePerLiter;

    public: 
        Car(const string No, const string name, const int year, const double km, string fuel, double mileage, double price) 
        : Vehicle(No, name, year, km), fuelType(fuel), mileageKmpl(mileage),fuelPricePerLiter(price){
            cout << "Car Constructor"<<endl;
        }
        double fuelCost(double km) const override{
            return km / mileageKmpl * fuelPricePerLiter; 
        }

        string vehicleType() const override{
            return "Car";
        }

        void describe() const override{
            Vehicle::describe();
            
            cout<<"Fuel Type : "<<fuelType<<endl;
            cout<<"Mileage : "<<mileageKmpl<<endl;
        }

        ~Car(){
            cout<<"Car Distructed"<<endl;
        }
};

class Truck : public Vehicle{
    protected:
        double payloadCapacityTons;
        double fuelEfficiencyKmpl;
    public:
        Truck(const string No, const string name, const int year, const double km, double ton, double efficiency) : 
        Vehicle(No, name, year, km), payloadCapacityTons(ton), fuelEfficiencyKmpl(efficiency){
            cout<<"[Truck Constructor]  "<<No<<endl;
        }

        double fuelCost(double km) const override{
            
            double reduction = payloadCapacityTons * (5.0/100.0);
            double effectiveEfficiency = fuelEfficiencyKmpl * (1 - reduction);
            double fuelRequired = km / effectiveEfficiency;
            return fuelRequired * 93.0;
        }

        string vehicleType() const override{
            return "Truck";
        }

        ~Truck(){
            cout<<"[Truck Distructor]  "<<endl;
        }
};

class ElectricTruck : public Truck{
    protected:
        double batteryCapacityKWh;
        double rangePerChargeKm;

    public:
        ElectricTruck(const string No, const string name, const int year, const double km, const double ton,const double efficiency, double capacity, double range) : 
        Truck(No, name, year, km, ton, efficiency), batteryCapacityKWh(capacity), rangePerChargeKm(range){
            cout<<"Electric Truck Consturctor"<<No<<endl;
        }
        double getBatteryCapacity() const {
            return batteryCapacityKWh;
        }

        double fuelCost(double km) const override{
            return (km / rangePerChargeKm) * batteryCapacityKWh * 9.50;
        }

        string vehicleType() const override{
            return "Electric Truck";
        }

        void describe() const override{
            Vehicle::describe();

            cout << "Battery Capacity/KWh : " <<  batteryCapacityKWh<<endl;
            cout << "Range of a Truck per KM : " << rangePerChargeKm<<endl;
        }

        ~ElectricTruck(){
            cout<<"Electric Truck Distructed"<<endl;
        }
};

class Van : public Vehicle{
    protected:
        int seatingCapacity;
        double mileageKmpl;

    public: 
        Van(const string No, const string name, const int year, const double km, int seatCapacity, double mileageKmpl) : 
        Vehicle(No, name, year, km),  seatingCapacity(seatCapacity), mileageKmpl(mileageKmpl){}

        double fuelCost(double km)const override{
            return  (km / mileageKmpl) * 106.0;
        }

        string vehicleType()const override{
            return "Van";
        }

        ~Van(){}
};

int main(){

    vector<Vehicle*> fleet; 

    fleet.push_back(new Car(
        "Mh 19 CW 0920", "Prajwal", 2024, 1200.00, "Petrol", 13.6, 106.0));

     fleet.push_back(new Car(
        "CAR102", "Amit", 2021, 30000,"Diesel", 18.0, 93.0));

    fleet.push_back(new Truck(
        "GJ 12 MC 2005", "RatanLal", 2010, 70534, 20.6, 8.5));

    fleet.push_back(new ElectricTruck(
        "CG 16 BC 0000", "Rahul", 2024, 22455, 4.5, 7.5, 500.0, 300.0 ));

    fleet.push_back(new Van(
        "MH 23 CA 2045", "Rakesh", 2013, 56456, 10, 22.0));

    double tripKm = 200.0;
    cout << "===== FLEET REPORT — Trip Distance: "<<tripKm<<" km ====="<<endl;

    double lowestCost = 0;
    Vehicle* mostEfficient = nullptr;

    for (Vehicle* v : fleet) {

        cout << "----------------------------------\n";

        v->describe();

        double cost = v->fuelCost(tripKm);

        cout << "Vehicle Type : " << v->vehicleType() << endl;
        cout << "Trip Cost    : Rs. " << cost << endl;


        // Identify ElectricTruck using dynamic_cast
        ElectricTruck* electric =
            dynamic_cast<ElectricTruck*>(v);

        if (electric != nullptr) {
            cout << "Battery Status: Electric Truck detected\n";
            cout << "Battery Capacity: "
                 << electric->getBatteryCapacity() << " kWh\n";
        }


        // Find lowest trip cost
        if (mostEfficient == nullptr || cost < lowestCost) {
            lowestCost = cost;
            mostEfficient = v;
        }
    }


        cout << "\n==================================\n";
        cout << "Most Fuel-Efficient Vehicle\n";
        cout << "Registration : "
            << mostEfficient->getRegNo() << endl;
        cout << "Type         : "
            << mostEfficient->vehicleType() << endl;
        cout << "Trip Cost    : Rs. "
            << lowestCost << endl;


    // Delete dynamically allocated objects
    for (Vehicle* v : fleet) {
        delete v;
    }

    fleet.clear();

    return 0;
}