// https://algoprog.ru/material/p1130

var
a, b : array[1..20] of longint;
i, j, k, n : longint;
begin
read(n);
for i := 1 to n do begin
read(a[i]);
b[i] := i;
end;
for i := 1 to n do
for j := 1 to n-i do
if a[j] < a[j + 1] then begin
k := a[j];
a[j] := a[j + 1];
a[j + 1] := k;
k := b[j];
b[j] := b[j + 1];
b[j + 1] := k
end;
for i := 1 to n do write(b[i], ' ')
end.