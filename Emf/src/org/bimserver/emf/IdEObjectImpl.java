package org.bimserver.emf;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class IdEObjectImpl extends MinimalEObjectImpl implements IdEObject {

	private static enum State {
		NONE,
		LOADING,
		LOADED
	}
	
	private long oid = -1;
	private int rid;
	private int pid;
	private State state = State.NONE;
	private LazyLoader lazyLoader;
	
	@Override
	public long getOid() {
		return oid;
	}

	@Override
	public void setOid(long oid) {
		this.oid = oid;
	}

	@Override
	public int getPid() {
		return pid;
	}

	@Override
	public int getRid() {
		return rid;
	}

	@Override
	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public Object eVirtualGet(int eDerivedStructuralFeatureID) {
		load();
		return super.eVirtualGet(eDerivedStructuralFeatureID);
	}
	
	@Override
	public Object eVirtualSet(int eDerivedStructuralFeatureID, Object value) {
		load();
		return super.eVirtualSet(eDerivedStructuralFeatureID, value);
	}
	
	@Override
	public boolean eVirtualIsSet(int eDerivedStructuralFeatureID) {
		load();
		return super.eVirtualIsSet(eDerivedStructuralFeatureID);
	}
	
	@Override
	protected Object eSetVirtualValue(int index, Object value) {
		load();
		return super.eSetVirtualValue(index, value);
	}
	
//	@Override
//	public void eUnset(EStructuralFeature eFeature) {
//		load();
//		super.eUnset(eFeature);
//	}
//	
//	@Override
//	public void eSet(EStructuralFeature eFeature, Object newValue) {
//		load();
//		super.eSet(eFeature, newValue);
//	}
//	
//	@Override
//	public Object eGet(EStructuralFeature eFeature) {
//		load();
//		return super.eGet(eFeature);
//	}
//	
//	@Override
//	public boolean eIsSet(EStructuralFeature eFeature) {
//		load();
//		return super.eIsSet(eFeature);
//	}
//	
//	@Override
//	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
//		load();
//		return super.eGet(eFeature, resolve);
//	}
//	
//	@Override
//	public Object eGet(EStructuralFeature eFeature, boolean resolve, boolean coreType) {
//		load();
//		return super.eGet(eFeature, resolve, coreType);
//	}
//	
//	@Override
//	public Object eGet(int featureID, boolean resolve, boolean coreType) {
//		load();
//		return super.eGet(featureID, resolve, coreType);
//	}
	
//	@Override
//	public Object dynamicGet(int dynamicFeatureID) {
//		load();
//		return super.dynamicGet(dynamicFeatureID);
//	}
//	
//	@Override
//	public void dynamicSet(int dynamicFeatureID, Object newValue) {
//		load();
//		super.dynamicSet(dynamicFeatureID, newValue);
//	}
//	
//	@Override
//	public void dynamicUnset(int dynamicFeatureID) {
//		load();
//		super.dynamicUnset(dynamicFeatureID);
//	}
//	
	@Override
	public Object eVirtualGet(int eDerivedStructuralFeatureID, Object defaultValue) {
		load();
		return super.eVirtualGet(eDerivedStructuralFeatureID, defaultValue);
	}
	
	@Override
	public Object eVirtualUnset(int eDerivedStructuralFeatureID) {
		load();
		return super.eVirtualUnset(eDerivedStructuralFeatureID);
	}
	
	@Override
	protected int eVirtualIndex(int eDerivedStructuralFeatureID, int action) {
		load();
		return super.eVirtualIndex(eDerivedStructuralFeatureID, action);
	}
	
	@Override
	protected int eVirtualIndexBits(int offset) {
		load();
		return super.eVirtualIndexBits(offset);
	}
	
	@Override
	protected Object eVirtualValue(int index) {
		load();
		return super.eVirtualValue(index);
	}
	
	@Override
	protected Object[] eVirtualValues() {
		load();
		return super.eVirtualValues();
	}
	
	public void load() {
		if (state == State.NONE && lazyLoader != null) {
			state = State.LOADING;
			lazyLoader.load(this);
			state = State.LOADED;
		}
	}

	@Override
	public void setLazyLoader(LazyLoader lazyLoader) {
		this.lazyLoader = lazyLoader;
	}

	@Override
	public void setLoaded() {
		this.state = State.LOADED;
	}
}