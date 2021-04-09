
#include <iostream>
using namespace std;

int main()
{

    int processNum, resources;
    processNum = 5; // P0, P1, P2, P3, P4
    resources = 3;

    // available matrix
    int available[3] = {3, 3, 2};

    // max matrix
    int max[5][3] = {{7, 5, 3},  // P0
                     {3, 2, 2},  // P1
                     {9, 0, 2},  // P2
                     {2, 2, 2},  // P3
                     {4, 3, 3}}; // P4

    // allocation matrix
    int allocation[5][3] = {{0, 1, 0},  // P0
                            {2, 0, 0},  // P1
                            {3, 0, 2},  // P2
                            {2, 1, 1},  // P3
                            {0, 0, 2}}; // P4

    int i, j, k;

    int ans[processNum], x[processNum], index = 0;
    for (k = 0; k < processNum; k++)
    {
        x[k] = 0;
    }
    int need[processNum][resources];
    for (i = 0; i < processNum; i++)
    {
        for (j = 0; j < resources; j++)
            need[i][j] = max[i][j] - allocation[i][j];
    }
    int y = 0;
    for (k = 0; k < 5; k++)
    {
        for (i = 0; i < processNum; i++)
        {
            if (x[i] == 0)
            {

                int flag = 0;
                for (j = 0; j < resources; j++)
                {
                    if (need[i][j] > available[j])
                    {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0)
                {
                    ans[index++] = i;
                    for (y = 0; y < resources; y++)
                        available[y] += allocation[i][y];
                    x[i] = 1;
                }
            }
        }
    }

    cout << "---------------------------\n";
    cout << "\tTHE SAFE SEQUENCE IS\t" << endl;
    for (i = 0; i < processNum - 1; i++)
        cout << " P" << ans[i] << " ->";
    cout << " P" << ans[processNum - 1] << endl;
    cout << "---------------------------\n";

    return (0);
}
