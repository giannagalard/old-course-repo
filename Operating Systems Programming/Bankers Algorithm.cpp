
#include <iostream>
using namespace std;

int main()
{

    int processNum, resources;
    processNum = 5; // P0, P1, P2, P3, P4
    resources = 3;

    // available matrix
    int available[3] = {1, 5, 3};
    
    // max matrix
    int max[5][3] = {{9, 1, 7},  // P0
                     {5, 3, 5},  // P1
                     {0, 2, 9},  // P2
                     {7, 7, 7},  // P3
                     {1, 3, 3}}; // P4

    // allocation matrix
    int allocation[5][3] = {{1, 6, 1},  // P0
                            {0, 0, 2},  // P1
                            {5, 0, 3},  // P2
                            {8, 7, 7},  // P3
                            {0, 0, 3}}; // P4

int i, j, k;

    int ans[processNum], x[processNum], index = 0;
    for (k = 0; k < processNum; k++)
    {
        x[k] = 0;
    }
