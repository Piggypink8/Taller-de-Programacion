program Parcial4;
const 
	dimF:= 6;
type
	tipoDenuncia = 1..dimF;
	
	dir = record
		calle : integer;
		altura : integer;
		end;
	
	denuncia = record
		categoria: tipoDenuncia;
		dni: String;
		direccion: dir;
		mes: string[10];
		dia: String[2];
		hora: String[6];
		end;

	lista = ^nodo;
	nodo = record
		elem: denuncia;
		sig: lista;
		end;
		
	denuncia2 = record
		calle:String;
		totalDenuncias: integer;
		totalMesJulio: integer;
		end;
		
	lista2 = ^nodo2;
	nodo2 = record
		elem: denuncia2;
		sig: lista;
		end;
		
	tiposDenuncia = array[tipoDenuncia] of lista;	

{	Inciso A	}

procedure iniciarVector(var v: tiposDenucnia);
var
	i:integer;
begin
	for i:= 1 to dimF do
		v[i] := nil;
end;
	
procedure leerDenuncia(var d:denuncia);
begin
	readln(d.dni);
	if(d.dni <> '0')then begin
		write('Ingrese categoria ');
		readln(d.categoria);
		write('Ingrese calle ');
		readln(d.direccion.calle);
		write('Ingrese esquina ');
		readln(d.direccion.altura);
		write('Ingrese mes ');
		readln(d.mes);
		write('Ingrese dia ');
		readln(d.dia);
		write('Ingrese hora ');
		readln(d.hora);
		
	end;
end;

procedure insertarOrdenado(var L:lista; d:denuncia);
var
	ant, act,nuevo: lista;
begin
	ant:= L;
	act := L;
	new(nuevo);
	nuevo^.elem := d;
	while((act <> nil) and (act^.elem..direccion.calle < d.direccion.calle))do begin
		ant := act;
		act := act^.sig;
	end;
	
	if(act = ant)then
		L:= nuevo
	else 
		ant^.sig:= nuevo;
	nuevo^.sig:= act;
end;

procedure cargarDenuncia(var v:tiposDenuncia);
var
	d:denuncia;
begin
	leerDenuncia(d);
	while(d.dni <> '0')do begin
		insertarOrdenado(v[d.categoria],d);
		leerDenuncia(d);
	end;
end;

{	Inciso B	}

procedure buscarMinimo(var v:tiposDenuncia; min:denuncia);
var
	pos,i:integer;
begin

	calleMin:= 9999;
	
	for i:= 1 to dimF do
		if (v[i] <> nil) then
			if (v[i]^.elem.direccion.calle < min.direccion.calle) then begin
				pos:= i;
				min:= v[pos]^.elem;
			end;
			
	if (calleMin <> 9999) then
		v[pos]:= v[pos]^.sig;	
	
end:

procedure merge(v:tiposDenuncia; var L:lista2);
var
	act:denuncia2;
	min:denuncia;
begin

	L:= nil;
	buscarMinimo(v,min);
	
	while(min.direccion.calle <> 9999)do
	begin
		act.direccion.calle := min.direccion.calle;
		act.totalMesJulio:= 0;
		act.totalDenuncias:= 0;
		
		while(act.direccion.calle = min.direccion.calle) do begin
			act.totalDenuncias:= act.totalDenuncias + 1;
			if(min.mes = 'Julio')then
				act.totalMesJulio := act.totalMesJulio + 1;
			buscarMinimo(v,min);
		end;
		
		agregarAdelante(L,act);
		
	end;
end;

procedure agregarAdelante(var L:lista2; denuncia:denuncia2);
var
	nue:lista2;
begin
	new(nue);
	nue^.elem:= denuncia;
	nue^.sig:= L;
	L:= nue;
end;

{	Inciso C	}

function calleMayorCantDenuncias(L:lista2; calleMax:integer; max:integer):integer;
begin
	if(L<>nil)then begin
		if(L^.elem.totalDenuncias >= max))then begin
			calleMax:= L^.elem.calle;
			max:= L^.elem.totalDenuncias;
		end;
		calleMayorCantDenuncias:= calleMayorCantDenuncias(L^.sig,calleMax,max);
	end
	else 
		calleMayorCantDenuncias:= calleMax;
end;

{	programa final	}
var
	v: tiposDenuncia;
	l:lista2;
	nroCalle,max:integer;
begin
	iniciarVector(v);
	cargarDenuncia(v);
	merge(v,l);
	max:= -1;
	
	writeln('Calle con mayor denuncias: ', calleMayorCantDenuncias(l,nroCalle,max))
END.

