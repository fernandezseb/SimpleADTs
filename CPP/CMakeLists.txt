cmake_minimum_required (VERSION 3.1)
project (SimpleADTs)

include_directories ("${PROJECT_SOURCE_DIR}/util")

set(CMAKE_CXX_STANDARD 11) 
set(SOURCES main.cpp util/Item.cpp util/PriorityQueue.cpp)

add_executable(SimpleADTs ${SOURCES})
