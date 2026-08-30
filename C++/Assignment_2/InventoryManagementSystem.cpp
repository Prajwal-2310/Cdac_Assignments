#include<iostream>
using namespace std;


class Product{

    int productId;
    string name;
    double price;
    int quantity;

    public:

    void acceptDetails(){
        cout << "Enter the ID of the ProductId : ";
        cin >> productId;
        cout << "Enter the name of a Product : ";
        cin >> name;
        cout << "Enter the price of am product : ";
        cin >> price;
        cout << "Enter the quantity of that perticular product: ";
        cin >> quantity;

    }              
    void displayDetails() const{
       
        cout << productId <<"\t"<< name<< "\t"<<price<<"\t"<<quantity<<"\t"<<totalValue()<<endl;

        
    }         
    double totalValue() const{
        return price * quantity;
    }  

    bool isLowStock(int threshold) const{
        if(quantity < threshold){
            return true;
        }else{
            return false;
        }
    }
};

double reorderCost(int qty, double unitPrice){
    return qty * unitPrice;
}          
double reorderCost(double qty, double unitPrice){
    return qty * unitPrice;
}        
double reorderCost(int qty, double unitPrice, double taxRate){
    double price = qty * unitPrice;
    double tax =  price * taxRate / 100;
    return price + tax;
} 
double applyDiscount(double price, double discountPercent = 10.0){
    double discount = price * discountPercent / 100;
    return  price - discount;
}

int main(){
    Product  P[5];

    cout << "Enter the threshold of low quantity product: ";
    int threshold;
    cin >> threshold;

    for(int i=0; i<5; i++){
        cout << "Enter the details of product "<<i+1<<endl;
        P[i].acceptDetails();
    }

    cout << "===== INVENTORY REPORT ====="<<endl;
    cout << "ID\tName\tPrice\tQty\tTotal Value"<<endl;
    for(int i=0; i<5; i++){
        P[i].displayDetails();
    }

    int highestIndex = 0;

    for(int i=0; i<5; i++){
        if(P[i].totalValue() > P[highestIndex].totalValue()){
        highestIndex = i;
        }
    }

    cout << "\nHighest Value Product: ";
    P[highestIndex].displayDetails();

    cout << "\nLow Stock (Threshold: " << threshold << "):" << endl;

    for(int i = 0; i < 5; i++){
        if(P[i].isLowStock(threshold)){
            P[i].displayDetails();
        }
    }

    cout << "Reorder cost (int quantity): "
     << reorderCost(10, 30.5) << endl;

    cout << "Reorder cost (double quantity): "
        << reorderCost(13.6, 30.5) << endl;

    cout << "Reorder cost with tax: "
        << reorderCost(10, 13.6, 12.5) << endl;

    cout << "Discount with default 10%: "
        << applyDiscount(70) << endl;

    cout << "Discount with 20%: "
        << applyDiscount(70, 20) << endl;


    return 0;
}