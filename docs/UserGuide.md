---
layout: page
title: User Guide
---
## Overview <br>
Notor is a desktop application for mentors to keep tabs on their mentees, **optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type faster than the average typing speed, Notor allows you to take notes quickly and efficiently, while keeping them in an easy to reference format, which is vital if you are taking notes during meetings with mentees.

* Table of Contents
{:toc}

### Using this User Guide

If you're new to Notor, hop over to [Quick Start](#Quick Start) to install and begin using it. If you already know what you want, use the Table of Contents to find the feature you are looking for, or the [Command Summary](#Command Summary) to view all commands available. If you've used Notor for a while and are looking to get the best out of Notor, 'level-up' by reading our [Tips on Using Notor](#Tips on Using Notor).

Some terminology that might help:
1. **List pane** : The panel located on the right, which is used to display the a list of persons or groups
2. **View pane** : The panel on the left, used to view notes, such as general notes
3. **Note Window**: The pop up window you may use to edit and add notes
4. **Command Box**: The box on the left pane, underneath the view pane, where you may type commands.

<div markdown="block" class="alert alert-info">
This block is used to highlight information you shold pay attention to

**information_source: Used when the following is information**<br>
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Used to highlight tips.
</div>

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
Used to highlight dangers
</div>

--------------------------------------------------------------------------------------------------------------------

## Quick Start
### 1. Setup
Ensure you have Java `11` or above installed in your computer. You can install Java `11` from [here](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html).
### 2. Installing the project
Download the latest `notor.jar` [here](https://github.com/AY2122S1-CS2103T-W08-1/tp/releases), and copy the file to the folder you want to use as the _home folder_ for your **Notor**.
### 3. Running the application
Double-click the file to start the application. If you have set up Java `11` correctly, the application should open, and the GUI similar to below should appear in a few seconds.
Note how the app contains some sample data. <br>
![Ui](images/Ui.png)

### 4. Try Running Examples!
Type the command in the command box and press Enter to execute it. e.g. Typing **help** and pressing Enter will
open the help window. <br>
Some example commands you can try:

* **`person /list`** : Lists all contacts.
* **`person 3 /delete`** : Deletes the 3rd contact (contact with index number `3`) shown in the current list.
* **`person User /create`** : Creates a person named `User`.
* **`group 1 /create t:Students`** : Creates a group at index 1` tagged with `Students`.
* **`person 3 /add g:Orbital`** : Adds the person with index `3` to the group `Orbital`.
* **`group /list`** : Lists all groups.
* **`group 1 /note`** : Edits the group note for the group with index number `1`.
* **`group 1 /create n:Artemis`** : Creates a subgroup `Artemis` inside the group with index number `1`.
* **`group 1 /untag t:Students`** : Removes the tag `Students` from the group with index number `1`.
* **`clear`** : Deletes all contacts.
* **`exit`** : Exits the application. <br>

Refer to the [Features](#Features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Command Breakdown
Here is a detailed breakdown of all the commands Notor has available. All the commands have a shortened command format, referred to interchangeably as 'advanced format' and 'short format'.

<div markdown="block" class="alert alert-info">

**information_source: Notes about the command format:**<br>
* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `person /create n:NAME`, `NAME` is a parameter which can be used as `/create n:John Doe`.
* Round brackets `()` refer to COMPULSORY arguments.<br>
  e.g `g:(GROUP_NAME)` means that the group name must be entered a that position.
* Items in square brackets are optional.<br>
  e.g `n:NAME [g:GROUP_NAME]` can be used as `n:Elton g:Orbital` or as `n:Elton`.
* Items with `…`​ after them can be used multiple times including zero times, with a comma separating terms.<br>
  e.g. `[t/TAG…​]` can be used as ` ` (i.e. 0 times), `t:tag1, tag2, tag3` etc.
* Parameters can be in any order.<br>
  e.g. if the command specifies `g:GROUP_NAME sg:SUBGROUP_NAME`, `sg:SUBGROUP_NAME g:GROUP_NAME` is also acceptable.
* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p:12341234 p:56785678`, only `p:56785678` will be taken.)
* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be
  ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.
</div>

### General Commands

#### Viewing help

Shows a message explaining how to access the help page.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
If you type in a commmand with no arguments and the command requires arguments, this command will display a prompt for the arguments which should be given.
</div>

![help message](images/helpMessage.png)

Format: `help`

#### Clearing all entries

Clears all entries from Notor. Be warned; data will be deleted and **will not be saved**. The intended use of this
 command is to clear the dummy starting data, but you can also use it to reset your Notor from within the program.

Format: `clear`
* Take care not to confuse this command with the more specific`/clearnote` command.

#### Exiting the program

Exits the program and saves your data.

Format: `exit`

#### Exporting data

Exports all the data of Notor into a CSV file. The exported CSV will be located in the same directory as Notor.

Format: `export`

### Working with people
The base functionality of Notor is to allow you to maintain notes on people who you mentor. These are the commands you can use with the `person` prefix to manage your contacts.

#### Creating a person:

Creates a person.

Format: `person (NAME) /create [p:PHONE] [e:EMAIL] [t:TAG1,TAG2,...] [g:GROUP_INDEX]`<br>
Advanced user Format: `p (NAME) /c [p:PHONE] [e:EMAIL] [t:TAG1,TAG2,...] [g:GROUP_INDEX]`

* Creates a person with the `NAME`.
* Optional arguments:
  * `PHONE`: Phone number of the person.
  * `EMAIL`: Email of the person.
  * `TAG1,TAG2..`: Tag(s) that describe the person.
  * `GROUP_INDEX`: Index of the group in notor to add the person to.

Examples:

* `person John Lim /create p:91119111 e:notor@notor.com t:Loves Dancing g:1`
* `p Michael Joe /c p:92229222 e:notor@notor.com t:Loves Singing g:2`

#### Adding a person to a group:

Adds a person at the given index to a specified group.

Format: `person (INDEX) /add (g:GROUP_NAME)`<br>
Advanced user Format: `p (INDEX) /a (g:GROUP_NAME)`

* Adds a person with the `INDEX` to `GROUP_NAME`.

Examples:

* `p John /add Lim g:Orbital`
* `p Mary /a g:Orbital`

### Adding a person to a subgroup: `person (INDEX) /add (g:GROUP_NAME sg:SUBGROUP_NAME)`

Adds a person at the given index to a specified subgroup of group.

Format: `person (INDEX) /add (g:GROUP_NAME sg:SUBGROUP_NAME)`<br>
Advanced user Format: `p (INDEX) /a (g:GROUP_NAME sg:SUBGROUP_NAME)`

* Adds a person with the `INDEX` to `SUBGROUP_NAME` of `SUBGROUP_NAME`.

Examples:
* `p John /add Lim g:Orbital sg:Artemis`
* `p Mary /a g:Orbital sg:Artemis`

#### Deleting a person :

Deletes an existing person.

Format: `person (INDEX) /delete`<br>
Advanced user Format: `p (INDEX) /d`

* Deletes an existing person at the given `INDEX`.

Examples:

* `person 1 /d `
* `p 2 /d`

#### Editing a person:

Edit an existing person's data.

Format: `person (INDEX) /edit [n:NAME] [p:PHONE] [e:EMAIL]`<br>
Advanced user Format:`p (INDEX) /e [n:NAME] [p:PHONE] [e:EMAIL]`

* Edits the person at the index `INDEX` and replaces the fields specified with the new parameters.
* Please specify at least one field to be edited.

* Optional arguments:
  * `NAME`: Name of the person.
  * `PHONE`: Phone number of the person.
  * `EMAIL`: Email of the person.


Examples:
* `person 1 /edit n:John Cena e:notor@notor.com`
* `p 2 /e n:Little Lamb p:93339333`

#### Removing a person from group:

Removes an existing person from a group.

Format: `person (INDEX) /remove (g:GROUP_NAME)`<br>
Advanced user Format:`p (INDEX) /r (g:GROUP_NAME)`

* Removes an existing person at the given `INDEX` from a `GROUP_NAME`.

Examples:
* `person 1 /remove g:Orbital`
* `p 2 /r g:Orbital`

### Removing a person from subgroup: `person (INDEX) /remove (g:GROUP_NAME sg:SUBGROUP_NAME)`

Removes an existing person from a subgroup.

Format: `person (INDEX) /remove (g:GROUP_NAME sg:SUBGROUP_NAME)`<br>
Advanced user Format:`p (INDEX) /r (g:GROUP_NAME sg:SUBGROUP_NAME)`

* Removes an existing person at the given `INDEX` from a `SUBGROUP_NAME` of `GROUP_NAME`.

Examples:
* `person 1 /remove g:Orbital sg:GroupA`
* `p 1 /r g:Orbital sg:GroupA`

#### Taking notes for a person:

Pops up a note window to take note for an existing person.

Format: `person (INDEX) /note`<br>
Advanced user Format:`p (INDEX) /n`

* Pops up a note window for an existing person at the given `INDEX` to take note.

Examples:

* `person 1 /note`
* `p 2 /n`

#### Clearing notes of a person:

Removes note of an existing person.

Format: `person (INDEX) /clearnote`<br>
Advanced user Format:`p (INDEX) /cn`

* Removes note of an existing person at the given `INDEX`.

Examples:

* `person 1 /clearnote`
* `p 2 /cn`

### Archiving People
Archiving people allows you to keep your Notor clean, without losing your information. You can use this in conjunction with the [Export](#exporting-data) command to make sure your data is safe. You can restore archived mentees at any time.

#### Archive a person
Archive a single person by the index.

Format: `person (INDEX) /archive`
Advanced user Format: `p (INDEX) /ar`

#### Archive All
Archive every person displayed in the list panel.

Format: `person /archive`
Advanced user Format: `p /ar`

#### List Archived Persons
Show the list of archived Persons.

Format: `person /listarchive`
Advanced user Format: `p /lar`

#### Unarchive
Returns the archived person to your regular person list in Notor.

Format: `person (INDEX) /unarchive`
Advanced user Format:`p (INDEX) /uar`

* You must be on the list of archived persons in order to use this command, as it takes the index as a compulsory parameter

### Working with groups/subgroups
A group is a way to make sure that 
<div markdown="block" class="alert alert-info">
:warning: **These commands will work only when groups or subgroups are listed.** :warning:
</div>

#### Creating a group:

Creates a group.

Format: `group (GROUP_NAME) /create`<br>
Advanced user Format: `g (GROUP_NAME) /c`

* Creates a new group with the name `GROUP_NAME`.
* The new group must not have a same name with other existing groups.
* The new group's name must not include backslash (`/`) or underscore (`_`).

Examples:

* `group Orbital /create` will create a new group called Orbital.
* `g Orbital /c`

### Deleting a group: `group (INDEX) /delete`

Deletes an existing group.

Format: `group (INDEX) /delete`<br>
Advanced user Format: `g (INDEX) /d`

* Deletes the group at the index specified.

Examples :

* `group 1 /delete` will delete the group at index 1.
* `g 1 /d`

### Creating a subgroup: `group (INDEX) /create n:SUBGROUP_NAME`
Creates a new subgroup. **This command only works when group are listed and not when subgroups are listed.**

Format: `group (INDEX) /create n:SUBGROUP_NAME`<br>
Advanced user Format: `g (INDEX) /c n:SUBGROUP_NAME`

* Creates a new subgroup of group at the index specified with the name `SUBGROUP_NAME`.
* The new subgroup must not have a same name with other existing subgroups in the same group.
* The new subgroup's name must not include backslash (`/`) or underscore (`_`).

Examples :

* `group 1 /create n:Artemis` will create a new subgroup Artemis in group at index 1.
* `g 1 /create n:Artemis`


### Adding notes to a group: `group (INDEX) /note`

Add notes on a group and saves the time when the note is added.

Format: `group (INDEX) /note`<br>
Advanced user Format: `group (INDEX) /n`

* Add notes on a group at the index specified.
* Entering the command will lead to a popup window where the user can edit notes for group at that index`.
* The time when the note is edited will be saved.

Examples :

* `group 1 /note` will prompt a popup window where the user can edit the notes for group at index 1.
* `g 1 /n`

## Filtering with Notors

Sometimes, you will want to view all people, groups, subgroups, or tags to understand what you have saved in your Notor. At other times, you will want to find those which fit into certain parameters. Here are the ways to view a subset of your data.

### List

List can show all persons, groups, subgroups, or tags which you have added to Notor. It can also list archived persons: see [Archiving People](#Archiving People).

#### _Listing all persons_ : `person /list`

Lists all persons in the list panel.

Format: `person /list`<br>
Advanced user Format:`p /l`

#### _List all groups_ : `group /list`

Format:  `group /list`<br>
Advanced user Format: `g /l`

#### _Listing all persons in a group_ : `group (INDEX) /list`

Use after you have listed out all groups (so you can select the index). Lists all persons in that group.

Format: `person (INDEX) /list`<br>
Advanced user Format:`p (INDEX) /l`

* Lists all persons of a group that is at the given `INDEX` .
* Do not confuse this with the list all subgroups command, whose first command word is `group`

Examples:

* `group 1 /list`
* `g 2 /l`

#### _List all subgroups in a group_ :

List all the subgroups within a group. Use after you have listed out all groups (so you can select the index)

* Do not confuse this with the list all persons command, whose first command word is `person`

Format: `group (INDEX) /list`<br>
Advanced user Format: `g (INDEX) /l`

Examples:

* `group 3 /list`
* `g 2 /l`


### Find

Find allows you to obtain the results that match with the keyword specified. You can filter in this way on people, groups, and subgroups. In addition, you may add additional parameters to your search, in order to narrow the search further.

### _Finding persons_ : `person /find (n:QUERY)`

Finds all persons that match your search term. You may search for substrings within a persons name, or for tags the user must be tagged with. If you specify multiple search terms, only those people which match ALL criteria will be returned.

Format: `person  /find [n:NAME_QUERY] [t:TAG1, TAG2...]`<br>
Advanced user Format:`p /f [n:NAME_QUERY] [t:TAG1, TAG2...]`

* Finds all persons that match with given `NAME_QUERY`, or are tagged with the tags specified.
* The query for name will match if the string exists within the name, regardless of case: `jo` will match `John` and `joanne`.
* Tags must be spelled exactly. You may specify more than one tag
* While the parameters have been marked optional, you should specify at least one parameter if you want to filter the results.

Examples:

* `person /find n:Alex t:graduated, engineering`
* `p /f n:Mary`
* `p /find n:Jo t:Final Year Project`

### _Find a group or subgroup_ : `group /find (g:KEYWORD)`

Find all the groups with the keyword specified. This will search for the keyword within the group's name.
Only works when group/s are shown in the list panel.

Format:  `group /find n:QUERY_NAME`<br>
Advanced user Format: `g /f n:QUERY_NAME`

* Find all the groups that match the `KEYWORD`.
* The keyword must not include backslash (`/`) or underscore (`_`).
* Substrings will match: `art` will match `Art Jammers`, `Smart cookie`, and `Artemis`

Examples of finding group:

* `group /find n:Artemis`
* `g /f n:GroupA`
* `group /f n:Test`

## Miscellaneous information

### Saving the data

Notor data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Notor data are saved as a JSON file `[JAR file location]/data/Notor.json`. Advanced users are welcome to update data
directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Notor will discard all data and start with an empty data file at the next run.
</div>

--------------------------------------------------------------------------------------------------------------------

## Tips on Using Notor
### Keeping Track of Successfully Executed Command History
Notor keeps tracks of successfully executed commands in the current instance,  allowing you to navigate through with Up arrow key starting from the most recent command.
Users can also use the Down arrow key to navigate back to the more recent command when they are navigating with Up arrow key.

### Keyboard Shortcuts
Notor has keyboard shortcuts to give you added convenience and allow you to control notor using your keyboard alone. Here are the shortcuts we have available.

**In Pop-Up Windows**
Navigate the buttons using the arrow keys. On Windows and Linux, select the button by pressing enter; on MacOS, press space.

**Note**:
- **TimeStamp** shortcut key types the current date and time in Note Window in this format `E, MMM dd yyyy HH:mm"`.
- Example: `Fri., Oct. 22 2021 00:07`

Shortcut Key            | Linux/Window                                   | MacOS
------------------------|------------------------------------------------|---------------------------------------
**TimeStamp**           | `Ctrl + T`                                     | `Cmd + T`
**Save**                | `Ctrl + S`                                     | `Cmd + S`
**Quit without Saving** | `Ctrl + W`                                     | `Cmd + W`
**Save and Quit**       | `Ctrl + Q`                                     | `Cmd + Q`


## Command Summary
Round brackets `()` refer to COMPULSORY arguments.
Square brackets `[]` refer to optional arguments.<p>
*TODO: Make command action words below link to their entries above.*

### Person
**Note**:
* For the **Create** and **List** commands, if you want to automatically add them to a group, please use the **List** command to make sure the `Group` you want to
  use the command on is displayed before using them via `GROUP_INDEX`.
* For the **Add** and **Remove** commands, please make sure that the `GROUP_NAME` is typed exactly as how it is spelt on
  the card.

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous Notor home folder.

--------------------------------------------------------------------------------------------------------------------

Action                    | Format                                                                        | Short Format
--------------------------|-------------------------------------------------------------------------------|--------------------------------------------------------------------
**Create**                | `person (NAME) /create [p:PHONE] [e:EMAIL] [t:TAG1,TAG2,...] [g:GROUP_INDEX]` | `p (NAME) /c [p:phone] [e:email] [t:TAG1,TAG2,...] [g:GROUP_INDEX]`
**Edit**                  | `person (INDEX) /edit [n:NAME] [p:PHONE] [e:EMAIL]`                           | `p (INDEX) /e [n:NAME] [p:phone] [e:email]`
**Delete**                | `person (INDEX) /delete`                                                      | `p (INDEX) /d`
**Add Group**             | `person (INDEX) /add (g:GROUP_NAME) `                                         | `p (INDEX) /a (g:GROUP_NAME)`
**Add SubGroup**          | `person (INDEX) /add (g:GROUP_NAME sg:SUBGROUP_NAME) `                        | `p (INDEX) /a (g:GROUP_NAME sg:SUBGROUP_NAME)`
**Remove Group**          | `person (INDEX) /remove (g:GROUP_NAME) `                                      | `p (INDEX) /r (g:GROUP_NAME)`
**Remove SubGroup**       | `person (INDEX) /remove (g:GROUP_NAME sg:SUBGROUP_NAME) `                     | `p (INDEX) /r (g:GROUP_NAME sg:SUBGROUP_NAME)`
**Note**                  | `person (INDEX) /note`                                                        | `p (INDEX) /n`
**Clear Note**            | `person (INDEX) /clearnote`                                                   | `p (INDEX) /cn`
**Tag**                   | `person (INDEX) /tag [t:TAG1,TAG2,...]`                                       | `p (INDEX) /t [t:TAG1,TAG2,...]`
**Untag**                 | `person (INDEX) /untag [t:TAG1,TAG2,...]`                                     | `p (INDEX) /ut [t:TAG1,TAG2,...]`
**Clear Tags**            | `person (INDEX) /cleartags`                                                   | `p (INDEX) / ct`
**List Persons**          | `person /list`                                                                | `p /l`
**List Persons in Group** | `person [INDEX] /list`                                                        | `p [INDEX] /l`
**Find**                  | `person /find (n:QUERY)`                                                      | `p /f (n:QUERY)`
**Archive**               | `person (INDEX) /archive`                                                     | `p (INDEX) /ar`
**Archive All**           | `person /archive`                                                             | `p /ar`
**List Archived Persons**       | `person /listarchive`                                                           | `p /lar`
**Unarchive**             | `person (INDEX) /unarchive`                                                   | `p (INDEX) /uar`

### Group

Action                 | Format                                         | Short Format
-----------------------|------------------------------------------------|---------------------------------------
**Create Group**       | `group (GROUP_NAME) /create` | `g (GROUP_NAME) /c`
**Create Subgroup**    | `group (INDEX) /create n:SUBGROUP_NAME`        | `g (INDEX) /c n:SUBGROUP_NAME`
**Delete**             | `group (INDEX) /delete`                        | `g (INDEX) /d`
**Note**               | `group (INDEX) /note`                          | `g (INDEX) /n`
**List Groups**        | `group /list`                                  | `g /l`
**List Out Subgroups** | `group (INDEX) /list`                          | `g (INDEX) /l`
**Find**               | `group /find (n:QUERY)`                        | `g /f (n:QUERY)`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
Before using the group actions, remember to use `g /list` or `g /find` to change the list display so that you can access the indexes of the group
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
for the **List** command, the `INDEX` argument can be either a `Group` or a `Person`, depending on what is in the list display. Change the `person /list` or `group /list`.
</div>

### General

Action     | Format   | Short Format
-----------|----------|----------
**Help**   | `help`   | `h`
**Exit**   | `exit`   | `e`
**Clear**  | `clear`  | `c`
**Export** | `export` | `exp`
