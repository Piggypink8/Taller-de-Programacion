program Parcial3;
var
	alquiler = record 
		dni: integer;
		patente: integer;
		mes: integer;
		anio: integer;
		end;
		
	lista = ^nodo;
	nodo = record
		elem: alquiler;
		sig: lista;
		end;
	
	arbol = ^hoja;
	hoja = record
		elem: lista;
		HI: arbol;
		HD: arbol;
		end;
		
procedure leerAlquiler(var a:alquiler);
begin
	writeln('Ingrese patente');
	readln(a.patente);
	if(a.patente <> 0)then begin
		writeln('Ingrese dni');
		readln(a.dni);
		writeln('Ingrese mes');
		readln(a.mes);
		writeln('Ingrese anio');
		readln(a.anio);
	end;
end;

procedure agregarAdelante(var L: lista; al:alquiler);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.elem = al;
	nuevo^.sig = L;
	L = nuevo;
end;

procedure agregarArbol(var a: arbol; al: alquiler);
var
begin
	if(a == nil)then begin
		new(a);
		agregarAdelante(a^.elem,alquiler);
		a^.HI = nil;
		a^.HD = nil;
	end;
	else
		if(a^.elem^.elem.patente > a.patente)then
			agregarArbol(a.HI,al);
		else
			agregarArbol(a.HD,al);
end;

procedure cargarArbol(var a:arbol);
var
	al:alquiler;
begin
	leerAlquiler(al);
	while(al.patente <> 0)do begin
		cargarArbol(a,al);
		leerAlquiler(al);
	end;
end;

// inciso B
function cantAlquileresConDni(a:arbol; dni:integer):integer;
var
	cant:integer;
begin
	cant := 0;
	if(a<>nil)then begin
		contarAlquileres(a^.elem,dni,cant);
		cant := cant + cantAlquileresConDni(a^.HI,dni) + cantAlquileresConDni(a^.HD,dni);
	end;
	
	cantAlquileresConDni:= cant;
end;

procedure contarAlquileres(L:lista;dni:integer; var cant:integer);
begin
	while(L <> nil)do begin
		if(L^.elem.dni == dni)
			cant:= cant + 1;
		L:= L^.sig;
	end;
end;


// inciso C

function cantAlquileresEnAnioEntre(a:arbol; a,b,anio:integer;):integer
var
	cant:integer;
begin
	cant:= 0;
	if((a<>nil) && (a^.elem^.patente > a) && (a^.elem^.patente < b))then begin
		contarAlquileresEnAnio(a^.elem,dni,cant);
		cant := cant + cantAlquileresEnAnioEntre(a^.HI,dni) + cantAlquileresEnAnioEntre(a^.HD,dni);
	end;
	cantAlquileresEnAnioEntre:= cant;
end;

procedure contarAlquileresEnAnio(L:lista;anio:integer; var cant:integer);
begin
	while(L <> nil)do begin
		if(L^.elem.anio == anio)
			cant:= cant + 1;
		L:= L^.sig;
	end;
end;

var
	a:arbol;
	cant: integer;
begin
	cargarArbol(a);
	cant := contarAlquileres(a,8);
	writeln('Cantidad de alquileres por el dni 8 son: ' + cant);
END.
