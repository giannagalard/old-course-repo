 #include <iostream>
 using namespace std;

void waitingT(int processes[], int j, int bt[], int wt[])
  {
    wt[0]=0;

    for(int i=1; i<j; i++)
      wt[i]=bt[i-1]+wt[i-1];

  }

void turnAroundTime(int processes[], int j, int bt[], int wt[], int tat[])
  {
    for(int i=0;i<j;i++)
      tat[i]=bt[i]+ wt[i];
  }

void firstComeFirstServe(int processes[], int j, int bt[] )
  {
    int wt[j], tat[j], totalWait = 0, totalTAT = 0;

    waitingT(processes,j,bt,wt);
    turnAroundTime(processes, j, bt, wt, tat);

    cout << "Processes " << "Burst Time " << "Waiting Time " << "Turn Around Time" << endl;

    for(int i=0; i<j; i++)
      {
        totalWait = totalWait + wt[i];
        totalTAT = totalTAT + tat[i];
        cout << "\t" << i+1 << "\t  " << bt[i] << "\t  " << wt[i] << "\t\t" << tat[i] << endl;
      }

    cout << "Average Waiting Time = " << (float)totalWait/(float)j;
    cout << " " << endl;
    cout << "Average Turn Around Time = " << (float)totalTAT/(float)j;
  }

  // Driver Code
  int main()
    {
      int j;

      cout << "Please enter the number of Processes: ";
      cin >> j;

      int processes[j];
      for(int i = 0; i < j; i++)
        processes[i] = i+1;

      int burstTime[j];
      for(int i=0;i<j;i++)
        {
          cout << "Please enter the Burst time of Processes: " << i+1<<"--> ";
          cin >> burstTime[i];
        }

        cout << " " << endl;
        cout << "----------------------------------------" << endl;
        cout << "   FIRST COME FIRST SERVE SCHEDULING" << endl;
        firstComeFirstServe(processes, j, burstTime);
