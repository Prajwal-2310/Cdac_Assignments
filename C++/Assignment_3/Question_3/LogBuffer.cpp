#include<iostream>
using namespace std;

class LogBuffer{

    char *buffer;
    int capacity;
    int size;
    static int instanceCount;

public:
    LogBuffer() : capacity(0), size(0){
        instanceCount++;
    }

    LogBuffer(int capacity) : capacity(capacity), size(0){
        buffer = new char[capacity];
        buffer[0] = '\0';
        cout << "LogBuffer Created "<<capacity<<endl;
    }

    LogBuffer(const LogBuffer& other){
        capacity = other.capacity;
        size = other.size;
        buffer = new char[capacity];

        for(int i=0; i<capacity; i++){
            buffer[i] = other.buffer[i];
        }
        cout <<"[LogBuffer Deep Copied] "<<capacity<<endl;
    }

    LogBuffer& operator=(const LogBuffer& other){
        capacity = other.capacity;
        size = other.size;
        if(this != &other){
            delete [] buffer;

            buffer = new char[capacity];

            for(int i=0; i<capacity; i++){
                buffer[i] = other.buffer[i];
            }
        }
        cout << "[LogBuffer Assigned] "<<capacity<<endl;
        return *this;
    }

    void append(const char* msg){
        int i = 0;

        while (msg[i] != '\0' && size < capacity - 1){
            buffer[size] = msg[i];
            size++;
            i++;
        }

        buffer[size] = '\0';
    }

    void print() const{
        cout << buffer <<endl;
        cout <<"==================================================================="<<endl;
    }

    void clear(){
        size = 0;
        buffer[0] = '\0';
    }

    static int getInstanceCount(){
        return instanceCount;
    }

    ~LogBuffer(){
        cout << "LogBuffer Destryod"<<endl;
        delete[] buffer;
    }
};
int LogBuffer::instanceCount = 0;

int main(){

LogBuffer log1(256);
log1.append("Server started on port 8080");
log1.append(" | Request received from 192.168.1.10");
log1.print();

LogBuffer log2 = log1;           

log2.append(" | Cached response sent");
cout << "log1 : "; log1.print(); 
cout << "log2 : "; log2.print();

LogBuffer log3(128);
log3 = log1;                     
log3.print();
log1.print();

log1 = log1;                     

cout << "Live LogBuffer objects : " << LogBuffer::getInstanceCount() << endl;

return 0;
}