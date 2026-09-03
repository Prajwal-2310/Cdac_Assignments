#include<iostream>
using namespace std;

enum class HttpStatus{
    ok            = 200,
    Created       = 201,
    BadRequest    = 400,
    Unauthorized  = 401,
    NotFound      = 404,
    ServerError   = 500
};

void handleResponse(HttpStatus status, const string& endpoint){
    int code  = static_cast<int>(status);
    switch(code){
        case 200:
            cout << "[GET "<<endpoint<<"]" 
                 << "         ->200 OK "
                 <<": Request successful"<<endl;
            break;

        case 201:
            cout << "[POST "<<endpoint<<"]" 
                 << "\t->201 Created "
                 <<": Resourse Created"<<endl;
            break;

        case 400:
            cout << "[POST "<<endpoint<<"]" 
                 << "\t->400 BadRequest "
                 <<": Invalid request"<<endl;
            break;

        case 401:
            cout << "[POST "<<endpoint<<"]" 
                 << "\t->401 Unauthorized "
                 <<": Authentication required"<<endl;
            break;

        case 404:
            cout << "[GET "<<endpoint<<"]" 
                 << "\t->404 NotFound "
                 <<": Endpoint does not exist"<<endl;
            break;

        case 500:
            cout << "[POST "<<endpoint<<"]" 
                 << "\t->200 ServerError "
                 <<": Internal server error - retry later"<<endl;
            break;

        default:
            cout <<"Enter valid status code...."<<endl;

    }
}

int main(){
    handleResponse(HttpStatus::ok, "/api/uesr");

    handleResponse(HttpStatus::Unauthorized, "/api/login");

    handleResponse(HttpStatus::NotFound, "/api/products/99");

    handleResponse(HttpStatus::ServerError, "/api/order");

    return 0;
}