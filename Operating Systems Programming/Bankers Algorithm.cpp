#include <iostream>
using namespace std;

int main()
{

	int processNum, resources;
	processNum = 5; // P0, P1, P2, P3, P4
	resources = 3; 

// available matrix
  int available[3] = { 3, 3, 2 }; 

// max matrix
  int max[5][3] = { { 7, 5, 3 }, // P0 
				{ 3, 2, 2 }, // P1
				{ 9, 0, 2 }, // P2
				{ 2, 2, 2 }, // P3
				{ 4, 3, 3 } }; // P4

// allocation matrix
	int allocation[5][3] = { { 0, 1, 0 }, // P0 
						{ 2, 0, 0 }, // P1
						{ 3, 0, 2 }, // P2
						{ 2, 1, 1 }, // P3
						{ 0, 0, 2 } }; // P4
