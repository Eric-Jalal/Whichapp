# Whichapp-Test

This repository containes a simple list application containing WhichApp countries list API for retrieving and loading in optimized manner with using Dagger2 as DI and RoomDB for chaching and LiveData for fetching the list and Retrofit for networking.
The project base structure is clean code according to this manner described here: https://github.com/android10/Android-CleanArchitecture

# Task description
By calling "https://api.whichapp.com/v1/countries" you will receive some countries data. write an android application that retrieves them, caches them, and loads them into a Recyclerview. The Recyclerview has a header with the text "Header Section" and a footer with the text "Footer section" at the beginning and the end of the list. 
Preferably do this using Retrofit for network calls, Room for caching, ViewModel and LiveData for UI manipulation, Dagger for dependency injection, Butterknife for view injection. If not familiar with any of these libraries, use your own method of work.
Non-functional requirements such as clean architecture, linting, naming habits, readability, comments, change management, resource management, memory management, etc. will be noticed.

-----------------------------------------------------------------------
```MIT License

Copyright (c) 2018 Amir J.Hosseini

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
