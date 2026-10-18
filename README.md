# Assignment 3 Bridge Pattern study reference

Prepared for Nurdaulet Mukhitden, SE-2537. Topic C: Reports.
AI-generated reference for learning.
Repository URL: https://github.com/unknow9error/sdp-3. Base commit: `7552e89c78c9e38017ad32ba60dd45b04794d864`.
Verified source commit: `7c464d43c7518d693ecf8270e44bb8f06e7d64f0`. The ZIP source matches this local commit.

## Build and run

```sh
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

Tested with Amazon Corretto 17.0.13. Expected summary: `SUMMARY: 7/7 PASS`.

| Role | Class | Path |
| --- | --- | --- |
| Abstraction | Report | src/Report.java |
| A1 | AttendanceReport | src/AttendanceReport.java |
| A2 | GradeReport | src/GradeReport.java |
| Implementor | Formatter | src/Formatter.java |
| I1 | TextFormatter | src/TextFormatter.java |
| I2 | HtmlFormatter | src/HtmlFormatter.java |
| I3 | MarkdownFormatter | src/MarkdownFormatter.java |
| Client | Main | src/Main.java |

Bridge field: `src/Report.java:5`.
Delegated execution: `src/AttendanceReport.java:15` and
`src/GradeReport.java:19`.
Switch: `src/Report.java:14`.
T5 identity check: `src/Main.java:45`.

## Expected results

- T1: TEXT Attendance | 3 of 4 attended (75%).
- T2: HTML article with Attendance and 3 of 4 attended (75%).
- T3: TEXT Grades | Average: 80.
- T4: HTML article with Grades and Average: 80.
- T5: reference equality true, ID and sessions unchanged; T1 output changes to T2 output.
- T6: Markdown heading Attendance and 3 of 4 attended (75%).
- T7: Markdown heading Grades and Average: 80.

Exact captured strings are in demo-output.txt. Checks compare application results
with fixed expected values; no successful label is hard-coded.
extension.diff is an actual Git source diff. Only MarkdownFormatter and Main change
within src between the base and extension commits. Local commits record actual
AI reference stages on this date; they do not prove independent student work.

## Files and remaining work

report.pdf: three-page English explanation and UML. uml.puml: editable UML source.
The course deadline was 4 October 2026 at 23:59. Check approved late-submission
arrangements with the instructor. LMS upload and personal defense remain.
Follow course authorship rules before using any work for assessment.
