// https://algoprog.ru/material/p111648
// https://studassistent.ru/turbo-pascal/napishite-programmu-kotoraya-opredelyaet-skolko-sharikov-budet-seychas-unichtozheno-turbo-pascal

var
   a,a1:array[1..1000]of integer;
   n,k,k1,i,i1,i2,n1:integer;
begin
     read(n);
     for i:=1 to n do
         read(a[i]);
     n1:=n;
     k:=3;
     while k>=3 do
           begin
           k:=0;
           k1:=0;
           i:=2;
           while i<=n do
               begin
               if a[i]=a[i-1] then
                  begin
                  k1:=k1+1;
                  if k<=k1 then
                     k:=k1+1;
                  if i=n then
                     begin
                     if k>=3 then
                        for i1:=1 to i-k do
                            a1[i1]:=a[i1]
                     end
                  end
               else begin
                    if k<=k1 then
                       k:=k1+1;
                    k1:=0;
                    if k>=3 then
                       for i1:=1 to i-k-1 do
                           begin
                           a1[i1]:=a[i1];
                           i:=n
                           end
                    end;
               i:=i+1
               end;
           if k>=3 then
              begin
              i1:=i1+1;
              if i1+k-1<>n then
                 begin
                 for i2:=i1+k to n do
                     begin
                     a1[i1]:=a[i2];
                     i1:=i1+1
                     end
                 end;
              n:=n-k;
              for i:=1 to n do
                  a[i]:=a1[i]
              end
           end;
     writeln(n1-n)
end.