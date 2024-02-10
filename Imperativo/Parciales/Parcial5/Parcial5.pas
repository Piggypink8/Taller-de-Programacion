program Parcial5;
const
	codP = 1..24;
	
type
	
	datos = record
		cod:codP;
		cantP:integer;
		monto: integer;
		end;
	
	lista2 = ^nodo2;
	nodo2 = record;
		elem:datos;
		sig:lista2;
		end;
		
	partida = record
		mes:integer;
		codigo:codP;
		monto:integer;
		end;
	
	lista = ^nodo;
	nodo = record
		elem:partida;
		sig:lista;
		end;
		
	elemArbol = record
		anio:integer;
		partidas:lista;
		end;
		
	arbol = ^hoja;
	hoja = record
		elem: elemArbol;
		HI:arbol;
		HD:arbol;
		end;
		
	{	Inciso 1	}
procedure leerPartida(var p:partida;var e:elemArbol);
begin
	readln(p.mes);
	readln(p.codigo);
	readln(e.anio);
	if(p.mes <> 12 and e.anio <> 2022 and p.codigo <> 24)then
		readln(p.monto);
end;

procedure insertarOrdenado(var L:lista; p:partida);
var
	act,nue,ant:lista;
begin
	act:= L;
	ant:= L;
	new(nue);
	nue^.elem:= partida;
	while((act <> nil) and (act^.elem.mes < p.mes))do begin
		ant := act;
		act := act^.sig;
	end;
	
	if(act = ant)then
		L:= nue;
	else
		ant^.sig:= nue;
	nue^.sig:= act
end;

procedure agregarArbol(var a:arbol; e:elemArbol; p:partida);
var
	nue:arbol;
begin

	if(a = nil)then begin
		new(nue);
		nue^.elem := e;
		insertarOrdenado(nue^.elem.partidas,p);
		nue^.HI := nil;
		nue^.HD:= nil;
		a:= nue;
	end
	else
		if(e.anio < a^.elem.anio)then
			agregarArbol(a^.HI,p);
		else
			if(e.anio > a^.elem.anio)
				agregarArbol(a^.HD,p);
			else	
				insertarOrdenado(a^.elem.partidas,p);
end;

procedure cargarArbol(var a:arbol);
var
	p:partida;
	e:elemArbol;
begin
	leerPartida(p,e);
	while((p.mes <> 12) and (e.anio <> 2022) and (p.codigo <> 24))do begin
		agregarArbol(a,e,p);
		leerPartida(p,e);
	end;
end;

	{	Inciso 2	}
	
procedure insertarOrdenado2(var L:lista2; cod,monto:integer);
var
	ant,act,nue:lista2;
begin
	ant:= L;
	act:= L;
	while(act <> nil and act^.elem.cod <> cod)do begin
		ant:= act;
		act:= act^.sig;
	end;
	if(act <> nil)then begin
		act^.elem.monto := act^.elem.monto + monto;
		act^.elem.cantP:= act^.elem.cantP + 1;
	end
	else begin
		new(nue)
		nue^.elem.codigo := cod;
		nue^.elem.monto :=  monto;
		nue^.elem.cantP:= 1;
		if(act = ant)then
			L:= nue;
		else
			ant^.sig := nue;
		nue^.sig := act;
	end;
			
end;

procedure recorrerLista(L:lista; var ln:lista2);
begin
	while((L <> nil))do begin
		insertarOrdenado2(ln,L^.elem.codigo,L^.elem.monto);
		L:= L^.sig;
	end;
end;

procedure recorrerArbol(a:arbol;var ln:lista2);
begin
	if(a<>nil)then begin
		recorrerLista(a^.elem,ln);
		recorrerArbol(a^.HI,ln);
		recorrerArbol(a^.HD,ln);
	end;
end;

	{	Inciso 3	}
function provMayorPartidas(L:lista2;provMax,max:integer):integer;
begin
	if(L <> nil)then begin
		if(L^.elem.cantP > max)then begin
			provMax:= L^.elem.codigo;
			max:= L^.elem.cantP
		end;
		provMayorPartidas:= provMayorPartidas(L^.sig,proxMax,max);	
		
	end
	else
		provMayorPartidas:= provMax;
	end;
end;

	{	Inciso4	  }
	
function contarPartidas(L:lista;a,b,mes:integer):integer;
begin
	while(L<>nil and L^.elem.anio > a and L^.elem.anio < b)do begin
		if(L^.elem.mes = mes)then
			cant:= cant + 1;
	end;
	
end;

procedure cantPartidasEntre(a:arbol;a,b,mes:integer; var cant:integer);
var
begin
	if(a <> nil)then begin
		contarPartidas(a^.elem,a,b,mes,cant);
		cantPartidasEntre(a^.HI,a,b,mes);
		cantPartidasEntre(a^.HD,a,b,mes);
	end;
end;


var

BEGIN
	
	
END.

