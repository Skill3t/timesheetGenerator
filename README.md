# timesheetGenerator

## Features
- Track time for multiple customer
- Export data to .xls
- SQLite DB
- No internet or cloude service needed

## Requirements
- Java
- Export template
- SQLite DB

## License

- MIT

## Resources
- “Creative Commons GLYPHICONS FREE ” by GLYPHICONS.com is licensed under CC BY 3.0
- Copyright © 2002-2017 Apache POI - the Java API for Microsoft Documents https://poi.apache.org/
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  http://www.apache.org/licenses/LICENSE-2.0
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
- https://bitbucket.org/xerial/sqlite-jdbc/downloads/ 
  Apache License Version 2.0, January 2004
  http://www.apache.org/licenses/

## DB

- CREATE TABLE "Customer" ( `id` INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, `name` TEXT NOT NULL UNIQUE )
- CREATE TABLE "TrackedTimeItem" ( `id` INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, `id_Customer` INTEGER, `kindOfAction` TEXT, `startTime` TEXT, `endTime` TEXT, `kommand` TEXT, `markInExport` INTEGER, FOREIGN KEY(`id_Customer`) REFERENCES `Customer`(`id`) )
- CREATE TABLE `User` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `tamplatePath` BLOB )
