#include<iostream>
#include<vector>
using namespace std;

class DataProcessor{
    protected:
        vector<string> records;
        vector<double> data;
    public:
        virtual void   loadData(const string& source) = 0;
        virtual void   processData() = 0;
        virtual void   exportResult(const string& destination) = 0;
        virtual string processorType() const = 0;
        virtual int    recordCount() const = 0;

        virtual void printSummary() const{
            cout<<"Processor Type : "<<processorType()<<endl;
            cout<<"Record Count   : "<<recordCount()<<endl;

            for(const string& str : records){
                cout<<str<<" "<<endl;
            }
            cout<<"======================================================================"<<endl;
            for(const double& val : data){
                cout<<val<<" "<<endl;
            }
        }
        virtual ~DataProcessor() = default;
};

class CSVProcessor : public DataProcessor{
    public:
        void loadData(const string& source) override{
           records.push_back("1001, yash, software developer, rebit, 22");
           records.push_back("1002, manas, coustomer enginner, browserstack, 23");
           records.push_back("1003, manish, database developer, jio, 23");
           records.push_back("1004, nishant, woolings, mernstack developer, 22");
           records.push_back("1005, nayan, fullstack developer, capgimini, 24");
        }

        void processData() override{
            for(string& str : records){
                for(char& c : str){
                    c = toupper(static_cast<unsigned char>(c));
                }
            }
        }

        void exportResult(const string& destination) override{
            cout << "Exporting CSV result to: " << destination << endl;
        }

        string processorType()const override{
            return "CSV";
        }

        int recordCount()const override{
            return records.size();
        }
};

class SensorStreamProcessor : public DataProcessor{
    protected:
        double sum = 0;
        double min = 0;
        double max = 0;
        double mean = 0;
    public:
        void loadData(const string& source) override{
            data.push_back(25.3);
            data.push_back(28.6);
            data.push_back(13.5);
            data.push_back(41.6);
            data.push_back(57.2);
            data.push_back(25.9);
            data.push_back(34.6);
            data.push_back(17.9);
            
        }

        void processData() override{
            min = data[0];
            max = data[0];

            for(double& val : data){
                if(val > max){
                    max = val;
                }

                if(val < min){
                    min = val;
                }

                sum = sum + val;
            }
             mean = sum/data.size();
        }

        void exportResult(const string& destination) override{
            cout << "Exporting Sensor Stream result to: "<< destination << endl;
            cout<<"Sensor Stream Statistical Summary "<<endl;
            cout<<"Mean of Sensor Stream : "<<mean<<endl;
            cout<<"Maximum Data          : "<<max<<endl;
            cout<<"Minimum Data          : "<<min<<endl;
            cout<<"Total Readings        : "<<data.size()<<endl;
        }

        string processorType() const override{
            return "SSP";
        }

        int recordCount()const override{
            return data.size();
        }


};

int main(){
    vector<DataProcessor*> pipeline;
    pipeline.push_back(new CSVProcessor());
    pipeline.push_back(new SensorStreamProcessor());
    for (auto* p : pipeline) {
        p->loadData("source_data");
        p->processData();
        p->printSummary();
        p->exportResult("output_dir");
        cout << "---" << endl;
    }
}